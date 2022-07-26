from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)


@app.route('/loginFormDoctor', methods = ['POST'])
def loginFormDoctor():
    print("logged in ")
    return redirect('/dashboardPageDoctor')