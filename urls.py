from django.urls import path,include
from . import views
from .views import d_dtcn

urlpatterns = [
    path('', views.home, name='home'),
    path('report/', views.connsql),
    path('checklogin/', views.checklogin),
    path("analyze", views.webpage ,name="analyze"),
    path('drivermain/', views.drivermain, name='drivermain'),
    path('landing_page/', views.landing_page, name = 'landing_page'),
    path('login/', views.login, name = 'login'),
     path('drowsiness_detection/', d_dtcn, name='drowsiness_detection'),
]
