from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app
from flask_app.model.model_appointment import Appointment
from flask_app.model.model_medication import Medication
from flask_app.model.model_vitals import HeartRate

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

# ************************ LOGIN and SIGN UP ********************************** #
@app.route('/')
def welcomePage():
    session['loggedIn'] = False
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
    if session['loggedIn'] == False:
        return render_template('/')

    return render_template("patient/dashboard/dashboard.html", first_name = session['first_name'])


# Appointments
@app.route('/appointmentsPage')
def appointmentsPage():
    if session['loggedIn'] == False:
        return render_template('/')
    data = {
        'users_id' : session['id']
    }
    appointments = Appointment.getAppointments(data)
    print(appointments)
    return render_template("patient/dashboard/appointments.html", appts = appointments)

@app.route('/appointmentsPage/add')
def appointmentsAdd():
    if session['loggedIn'] == False:
        return render_template('/')
    return render_template("patient/dashboard/forms/appointmentsAdd.html")



# Medications
@app.route('/medicationsPage')
def medicationsPage():
    if session['loggedIn'] == False:
        return render_template('/')
    medications = Medication.getAllMeds()
    print(medications)
    return render_template("patient/dashboard/medications.html", meds = medications)

@app.route('/medicationsPage/add')
def medicationsAdd():
    if session['loggedIn'] == False:
        return render_template('/')
    return render_template("patient/dashboard/forms/medicationsAdd.html")


# Vitals
@app.route('/vitalsPage')
def vitalsPage():
    if session['loggedIn'] == False:
        return render_template('/')
    return render_template("patient/dashboard/vitals.html")

@app.route('/vitalsPage/add')
def vitalsAdd():
    if session['loggedIn'] == False:
        return render_template('/')
    return render_template("patient/dashboard/forms/vitalsAdd.html")





