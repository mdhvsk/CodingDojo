from time import time
from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app
from flask_app.model.model_patient import Patient
from flask_app.model.model_medication import Medication
from flask_app.model.model_appointment import Appointment
from flask_app.model.model_vitals import BloodPressure, BloodSugar, HeartRate

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route('/patientVerificationForm', methods = ["POST"])
def patientVerificationForm():
    return redirect('/verification')

@app.route('/signUpForm', methods = ['POST'])
def signUpForm():
    print("Signed in")
    answer = Patient.validateSignInForm(request.form)
    if answer == False:
        return redirect('/signUpPage')
    hashedPassword = bcrypt.generate_password_hash(request.form['password'])
    data = {
        'first_name': request.form['first_name'],
        'last_name': request.form['last_name'],
        'email': request.form['email'],
        'password': hashedPassword
    }

    id = Patient.registerUser(data)
    print(id)
    user_in_db = Patient.getUserByEmail(request.form)
    session['id'] = user_in_db['id']
    session['email'] = user_in_db['email']
    session['first_name'] = user_in_db['first_name']
    session['last_name'] = user_in_db['last_name']
    session['loggedIn'] = True

    return redirect('/dashboardPage')

@app.route('/loginForm', methods = ['POST'])
def loginForm():
    print("logged in ")
    user_in_db = Patient.getUserByEmail(request.form)
    if user_in_db == False:
        flash("Invalid Email/Password", 'login')
        return redirect("/loginPage")

    if not bcrypt.check_password_hash(user_in_db['password'], request.form['password']):
        flash("Invalid Email/Password", 'login')
        return redirect('/')
    session['id'] = user_in_db['id']
    session['email'] = user_in_db['email']
    session['first_name'] = user_in_db['first_name']
    session['last_name'] = user_in_db['last_name']
    session['loggedIn'] = True
    return redirect('/dashboardPage')

@app.route('/logoutForm', methods = ['POST'])
def logoutForm():
    print("logged out ")
    session.clear()
    return redirect('/')



# ******************* LOGIN/LOGOUT END *******************

@app.route('/addAppointment', methods = ['POST'])
def addAppointment():
    isValid = Appointment.validateAddAppointment(request.form)
    if isValid == False:
        return redirect('/appointmentsPage/add')
    originalStart = request.form['start_time']
    originalEnd = request.form['end_time']
    startTime = f"{originalStart[0:4]}-{originalStart[5:7]}-{originalStart[8:10]} {originalStart[11:13]}:{originalStart[14:16]}:00"
    endTime = f"{originalEnd[0:4]}-{originalEnd[5:7]}-{originalEnd[8:10]} {originalEnd[11:13]}:{originalEnd[14:16]}:00"

    data = {
        'title': request.form['title'],
        'start_time': startTime,
        'end_time': endTime,
        'description': request.form['description'],
        'frequency': request.form['frequency'],
        'users_id': session['id']
    }

    print(data)
    newID = Appointment.insertAppointments(data)

    return redirect('/appointmentsPage')

@app.route('/deleteAppointment', methods = ['POST'])
def deleteAppointment():
    data = {
        'id': request.form['id']
    }

    x = Appointment.deleteAppointment(data)
    return redirect('/appointmentsPage')

# ******************* APPOINTMENT END *******************



@app.route('/addMedication', methods = ['POST'])
def addMedication():
    isValid = Medication.validateAddMeds(request.form)
    if isValid == False:
        return redirect('/medicationsPage/add')
    days_of_week = Medication.calculateDays(request.form)
    times_of_day = Medication.calculateTimes(request.form)
    data = {
        'name': request.form['name'],
        'dosage_mg': request.form['dosage_mg'],
        'dosage_pills': request.form['dosage_pills'],
        'comment': request.form['comment'],
        'total_pills': request.form['total_pills'],
        'pill_count': request.form['total_pills'],
        'days_of_week': days_of_week,
        'times_of_day': times_of_day,
        'user_id': session['id']
    }
    newID = Medication.insertMeds(data)
    return redirect('/medicationsPage')

@app.route('/takeMedication', methods = ['POST'])
def takeMedication():
    Medication.takeMedication(request.form)
    return redirect('medicationsPage')

@app.route('/editMedication', methods = ['POST'])
def getOneMedication():
    med = Medication.getOneMedication(request.form)




# ******************* MEDICATIONS END *******************

@app.route('/addHeartRate', methods = ['POST'])
def addHeartRate():
    data = {
        'heart_rate': request.form['heart_rate'],
        'patient_id': session['id']
    }
    newID = HeartRate.insertHeartRate(data)
    x = HeartRate.plotHeartRate(data)


    return redirect('/vitalsPage')



@app.route('/addBloodPressure', methods = ['POST'])
def addBloodPressure():
    data = {
        'systolic_data': request.form['systolic_data'],
        'diastolic_data': request.form['diastolic_data'],
        'patient_id': session['id']
    }

    newID = BloodPressure.insertBloodPressure(data)
    x = BloodPressure.plotbloodPressure(data)
    return redirect('/vitalsPage')


@app.route('/addBloodSugar', methods = ["POST"])
def addBloodSugar():
    if request.form['measurementUnits'] == "mM":
        blood_sugar_mmol_l = float(request.form['blood_sugar'])
        blood_sugar_mg_dl =  (blood_sugar_mmol_l*18)
    if request.form['measurementUnits'] == "mg_dl":
        blood_sugar_mg_dl = float(request.form['blood_sugar'])
        blood_sugar_mmol_l = format(blood_sugar_mg_dl/18, ".2f")

    data = {
        'blood_sugar_mg_dl': blood_sugar_mg_dl,
        'blood_sugar_mmol_l': blood_sugar_mmol_l,
        'patient_id': session['id']
    }

    newID = BloodSugar.insertBloodSugar(data)
    x = BloodSugar.plotbloodSugar(data)
    return redirect('/vitalsPage')


    # ************************ Vitals END ********************************** #


@app.route('/editAccount', methods = ['POST'])
def editAccountInfo():

    return redirect('/accountPage')