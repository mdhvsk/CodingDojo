from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

# ************************ LOGIN and SIGN UP ********************************** #
@app.route('/')
def welcomePage():
    return render_template("welcome.html")

@app.route('/verification')
def verification():
    return render_template("/patient/login_and_reg/patient_verification.html")

@app.route('/signUpPage')
def signUpPage():
    return render_template("/patient/login_and_reg/sign_up.html")

@app.route('/loginPage')
def loginPage():
    return render_template("/patient/login_and_reg/login.html")


# ************************ DASHBOARD ********************************** #


@app.route('/dashboardPage')
def dashboardPage():
    return render_template("patient/dashboard/dashboard.html")


# Appointments
@app.route('/appointmentsPage')
def appointmentsPage():
    return render_template("patient/dashboard/appointments.html")

@app.route('/appointmentsPage/add')
def appointmentsAdd():
    return render_template("patient/dashboard/forms/appointmentsAdd.html")
    


# Medications
@app.route('/medicationsPage')
def medicationsPage():
    return render_template("patient/dashboard/medications.html")

@app.route('/medicationsPage/add')
def medicationsAdd():
    return render_template("patient/dashboard/forms/medicationsAdd.html")


# Vitals
@app.route('/vitalsPage')
def vitalsPage():
    return render_template("patient/dashboard/vitals.html")

@app.route('/vitalsPage/add')
def vitalsAdd():
    return render_template("patient/dashboard/forms/vitalsAdd.html")





