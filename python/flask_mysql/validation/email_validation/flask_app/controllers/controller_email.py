from flask import Flask, session, render_template, redirect, request
from flask_app import app
from flask_app.model.model_email import Email

@app.route('/')
def inputEmailPage():
    return render_template('inputEmail.html', )


@app.route('/addEmail', methods = ['POST'])
def addEmail():

    if not Email.validate_email(request.form):
        return redirect('/')


    newEmail = Email.add_email(request.form)
    session['id'] = newEmail
    print(newEmail)
    return redirect('/emailList')


@app.route('/emailList')
def emailList():
    data = {
        'id': session['id']
    }
    currEmail = Email.get_one_email(data)

    currList = Email.get_all()

    return render_template('emailList.html', email = currEmail, emailList = currList)



