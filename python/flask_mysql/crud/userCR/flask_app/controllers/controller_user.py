from flask_app import app

from flask import Flask, render_template, redirect, request, session
from flask_app.model.model_user import User


@app.route('/')
def index ():
    users = User.get_all()
    # print(users)
    return render_template('read_all.html', all_users = users)

# ADD ***********************************************************


@app.route('/showCreate', methods = ['GET'])
def showCreate ():
    return render_template('create.html')


@app.route('/addUser', methods = ['POST'])
def addUser():
    data = {
        "first_name" : request.form['first_name'],
        "last_name" : request.form['last_name'],
        "email": request.form['email']
    }
    newUser = User.create(data)
    print(newUser)
    return redirect('/')

# SHOW ***********************************************************


@app.route('/showReadInfo', methods = ['POST'])
def showReadInfo():
    session['id'] = request.form['id']
    return redirect('/showRead')

@app.route('/showRead', methods = ['GET'])
def showRead ():
    print(session['id'])
    data = {
        'id' : session['id']
    }
    one_user = User.read_one(data)
    print(one_user)
    return render_template('read_one.html', one_user = one_user)

# EDIT ***********************************************************

@app.route('/editInfo', methods = ['POST'])
def showEditInfo():
    session['id'] = request.form['id']
    print(session['id'])
    return redirect('/showEdit')

@app.route('/showEdit', methods = ['GET'])
def showEdit ():
    return render_template('edit.html')

@app.route('/editForm', methods = ['POST'])
def editForm():
    data = {
        "first_name" : request.form['first_name'],
        "last_name" : request.form['last_name'],
        "email": request.form['email'],
        'id': session['id']
    }
    print(data)
    User.edit(data)
    return redirect('/showRead')

# DELETE ***********************************************************


@app.route('/delete', methods = ['POST'])
def delete ():
    print(request.form)
    data = {
        'id': request.form['id']
    }
    print(data)
    User.delete(data)
    return redirect('/')



