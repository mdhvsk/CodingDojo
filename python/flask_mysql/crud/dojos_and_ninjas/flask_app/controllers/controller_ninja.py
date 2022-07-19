from flask_app import app

from flask import Flask, render_template, redirect, request, session
from flask_app.model.model_ninja import Ninja
from flask_app.model.model_dojo import Dojo

# DOJOS ************************************************************************

@app.route('/dojos')
def dojoHome():
    dojos = Dojo.get_all_dojos()
    return render_template('home.html', all_dojos = dojos)


@app.route('/createDojo', methods = ["POST"])
def createDojo():
    data = request.form
    newDojo = Dojo.create_dojo(data)
    return redirect('/dojos')


# NINJAS ************************************************************************

@app.route('/ninjas')
def ninjaHome():
    dojos = Dojo.get_all_dojos()
    return render_template("newNinja.html", all_dojos = dojos)

@app.route('/createNinja', methods = ["POST"])
def createNinja():
    data = request.form
    print(data)
    newNinja = Ninja.createNinja(data)
    print(newNinja)
    return redirect('/dojos')


# NINJAS ************************************************************************

@app.route('/dojos/<id>')
def getNinjaList(id): 
    print("Made it to the function")
    data = {
        "id":id
        }
    dojo = Dojo.get_one_dojo(data)
    ninja_list = Ninja.getNinjas(data)
    dojo = dojo[0]
    print(dojo)
    print(ninja_list)
    return render_template('ninjaList.html', one_dojo = dojo, ninjas = ninja_list)


