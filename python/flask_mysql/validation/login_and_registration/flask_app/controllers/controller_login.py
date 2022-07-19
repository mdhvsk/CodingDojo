from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app
from flask_app.model.model_user import User
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)



@app.route('/')
def login_and_registration():
    session['loggedIn'] = False
    return render_template('homePage.html')

@app.route('/register', methods = ["POST"])
def register():
    answer = User.validateRegisterForm(request.form)
    if answer == False:
        return redirect('/')
    hashedPassword = bcrypt.generate_password_hash(request.form['password'])
    data = {
        'first_name': request.form['first_name'],
        'last_name': request.form['last_name'],
        'email': request.form['email'],
        'password': hashedPassword
    }

    id = User.registerUser(data)

    user_in_db = User.getUserByEmail(request.form)
    session['email'] = user_in_db['email']
    session['first_name'] = user_in_db['first_name']
    session['last_name'] = user_in_db['last_name']
    session['loggedIn'] = True
    return redirect('/userPage')


@app.route('/login', methods = ["POST"])
def login():
    user_in_db = User.getUserByEmail(request.form)
    if user_in_db == False:
        flash("Invalid Email/Password", 'login')
        return redirect("/")

    if not bcrypt.check_password_hash(user_in_db['password'], request.form['password']):
        flash("Invalid Email/Password", 'login')
        return redirect('/')

    session['email'] = user_in_db['email']
    session['first_name'] = user_in_db['first_name']
    session['last_name'] = user_in_db['last_name']
    session['loggedIn'] = True

    return redirect('/userPage')

@app.route('/userPage')
def getUserPage():
    if session['loggedIn'] == False:
        return redirect('/')
    return render_template("userPage.html", first_name = session['first_name'])

@app.route('/logout', methods = ['POST'])
def logout():
    session.clear()
    return redirect('/')