# from django.contrib.auth.models import User
import base64
from django.contrib.auth import authenticate, login
from django.http import HttpResponse
from django.shortcuts import render
# from .models import *
from django.core.mail import EmailMessage
from django.views.decorators import gzip
from django.http import StreamingHttpResponse
import cv2
import threading
from io import BytesIO
from PIL import Image
from django.shortcuts import render, redirect
import os
import cv2
import base64
import numpy as np
from django.http import HttpResponse
from django.views.decorators import gzip
from django.views.decorators.csrf import csrf_exempt
import pyodbc
import datetime
from django.shortcuts import render

#home
def home(request):
    return render(request, 'home.html')

#login page
def login(request):
    return render(request, 'login.html')
#-----------------------------------------------
#driver main page
def drivermain(request):
    return render(request, 'driver_main.html')

#landing page
def landing_page(request):
    return render(request, 'landing page.html')

#webpage
@gzip.gzip_page
def webpage(request):
    return render(request, 'drowsiness_detection.html')

# function for calling main drowsiness detction file
def d_dtcn(request):
	if request.method == 'POST' and request.POST.get('Start') == 'Start':
		os.system("python myapp\drowsiness_detection.py --shape_predictor shape_predictor_68_face_landmarks.dat")
		
	return render(request, 'drowsiness_detection.html')

# check login
def checklogin(request):
    if request.method == 'POST':
        username = request.POST['username']
        password = request.POST['password']
        
        conn = pyodbc.connect(Driver='{sql server}',
                          Server='VARSHA',
                          Database='Drowssiness_detection',
                          TrustedConnection='yes')
        cursor = conn.cursor()
        cursor.execute('select user_type from login where username=? and password = ?', username, password)
        results = cursor.fetchall()
        labels = [r[0] for r in results]
        if labels[0] == 'Driver':
            return redirect('/drivermain/')
        elif labels[0] == "Manager":
            return redirect('/report/')
        else:
            return redirect('/login/')
    else:
        return redirect('/login')

# Sql connection for connecting front end with database
def connsql(request):
    conn = pyodbc.connect(Driver='{sql server}',
                          Server='VARSHA',
                          Database='Drowssiness_detection',
                          TrustedConnection='yes')
    cursor = conn.cursor()
    cursor.execute('select * from journey_details ORDER BY start_time DESC')
    results = cursor.fetchall()
    cursor.execute('select DISTINCT(start_time) from journey_details  ORDER BY start_time DESC')
    res = cursor.fetchall()
    labels = [r[0].strftime("%H:%M:%S") for r in res]
    eye_blink_status = [r[2] for r in results]
    blink_count = [r[3] for r in results]
    alarm_duration = [r[4] for r in results]
    chart_data = {'labels': labels, 'eye_blink_status': eye_blink_status, 'alarm_duration':alarm_duration,'blink_count':blink_count}
    return render(request, 'index.html', {'chart_data': chart_data})