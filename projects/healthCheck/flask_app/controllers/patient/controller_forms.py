from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route('/patientVerificationForm', methods = ["POST"])
def patientVerificationForm():
    return redirect('/verification')

@app.route('/signUpForm', methods = ['POST'])
def signUpForm():
    print("Signed in")
    return redirect('/dashboardPage')

@app.route('/loginForm', methods = ['POST'])
def loginForm():
    print("logged in ")
    return redirect('/dashboardPage')

@app.route('/logoutForm', methods = ['POST'])
def logoutForm():
    print("logged out ")
    return redirect('/')

@app.route('/addAppointment', methods = ['POST'])
def addAppointment():
    return redirect('/appointmentsPage')
