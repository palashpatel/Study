import cv2
import os
from keras.models import load_model
import numpy as np
from pygame import mixer
import time
import cmake
import dlib
import imutils
from scipy.spatial import distance
from datetime import datetime
import pyodbc
from datetime import datetime

#to create a link between database and drowsiness detection  page
def connection():
  driver = "{ODBC Driver 17 for SQL Server}"
  server = "VARSHA"
  database = "Drowssiness_detection"
  #without user name and password(login with windows authentication)
  conn = pyodbc.connect("DRIVER=" + driver+ ";SERVER=" + server + ";DATABASE=" + database + ";Trusted_Connection=yes;" )
  return conn

def throw_html(frame):

    return frame


def eye_aspect_ratio(eye):
    A = distance.euclidean(eye[1], eye[5])
    B = distance.euclidean(eye[2], eye[4])
    C = distance.euclidean(eye[0], eye[3])
    ear = (A + B) / (2.0 * C)
    return ear

detector = dlib.get_frontal_face_detector()
predictor = dlib.shape_predictor(r'myapp\dds_file\shape_predictor_68_face_landmarks.dat')
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_eye.xml')

EAR_THRESHOLD = 0.25
start_time = None
end_time = None
active = True
currentDateAndTime = datetime.now()
mixer.init()


# load the model
model = load_model(r'myapp\premodel/premodel.h5')

# load sound
sound = mixer.Sound(r'myapp\sound files/alarm.mp3')
cap = cv2.VideoCapture(0)
Score = 0
thicc = 2
blink_count = 0
blink_data = []

while True:
    ret, frame = cap.read()
    height, width = frame.shape[0:2]
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.2, minNeighbors=3)
    eyes = eye_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=1)
    dlib_faces = detector(gray)
    cv2.rectangle(frame, (0, height - 50), (150, height), (0, 0, 0), thickness=cv2.FILLED)

    for (x, y, w, h) in faces:
        cv2.rectangle(frame, pt1=(x, y), pt2=(x + w, y + h), color=(255, 0, 0), thickness=3)

    for (ex, ey, ew, eh) in eyes:

        # preprocessing steps
        eye = frame[ey:ey + eh, ex:ex + ew]
        eye = cv2.resize(eye, (80, 80))
        eye = eye / 255
        eye = eye.reshape(80, 80, 3)
        eye = np.expand_dims(eye, axis=0)

        # preprocessing is done now model prediction
        prediction = model.predict(eye)

        # if eyes are closed
        if prediction[0][0] > 0.30:
            Score = Score + 1
            if (Score > 7):
                try:
                    sound.play()
                except:
                    pass
                if (thicc < 16):
                    thicc = thicc + 2
                else:
                    thicc = thicc - 2
                    if (thicc < 2):
                        thicc = 2
                cv2.rectangle(frame, (0, 0), (width, height), (0, 0, 255), thicc)

        # if eyes are open
        elif prediction[0][1] > 0.90:
            Score = Score - 1
            if (Score < 0):
                Score = 0

    cv2.putText(frame, "Score: {}".format(Score), (20, height - 20), fontFace=cv2.FONT_HERSHEY_COMPLEX_SMALL,
                fontScale=1, color=(255, 255, 255),
                thickness=1, lineType=cv2.LINE_AA)
    for face in dlib_faces:
        landmarks = predictor(gray, face)
        left_eye = []
        right_eye = []
        for i in range(36, 42):
            left_eye.append((landmarks.part(i).x, landmarks.part(i).y))
        for i in range(42, 48):
            right_eye.append((landmarks.part(i).x, landmarks.part(i).y))
        left_ear = eye_aspect_ratio(left_eye)
        right_ear = eye_aspect_ratio(right_eye)
        avg_ear = (left_ear + right_ear) / 2.0
        # start_time = currentDateAndTime.strftime("%Y-%m-%d %H:%M:%S")
        start_time = datetime.now()
        start_time = start_time.replace(microsecond=0)
        if avg_ear < EAR_THRESHOLD:
            active = False
            if end_time is None:
                blink_count += 1
                blink_data.append(blink_count)
        else:
            end_time = None
            active = True
        for (x, y) in left_eye:
            cv2.circle(frame, (x, y), 1, (0, 255, 0), -1)
        for (x, y) in right_eye:
            cv2.circle(frame, (x, y), 1, (0, 255, 0), -1)

    if Score > 5:
        alarm_duration = Score - 5
    else: 
        alarm_duration = 0
    
    if(start_time != None):

        # connection to database
        conn = connection()
        cursor = conn.cursor()
        cursor.execute('insert into journey_details (userid,start_time,eye_closed_time, blink_count, alarm_duration) values(?,?,?,?,?);',1,start_time, Score, blink_count, alarm_duration)
        conn.commit()
        cursor.close()

    cv2.imshow('frame', frame)
    throw_html(frame)
    if cv2.waitKey(33) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()