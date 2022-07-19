from flask import Flask, render_template, request, redirect, session
from flask_app import app

from flask_app.model.model_dojos import Dojo


@app.route('/')
def index():
    print(request.form)
    return render_template('index.html')



@app.route('/info', methods = ["POST"])
def info():
    session['name'] = request.form['name']
    session['location'] = request.form['location']
    session['language'] = request.form['language']
    session['comment'] = request.form['comment']
    print(request.form)
    if not Dojo.validate_dojos(request.form):
        return redirect('/')
        
    curr = Dojo.addUser(request.form)
    return redirect('/infoPage')


@app.route('/infoPage')
def display():
    return render_template('info.html', name = session['name'], location = session['location'],
    language = session['language'], comment = session['comment'])

@app.route('/back', methods = ["POST"])
def back():
    session.clear()
    return redirect('/')