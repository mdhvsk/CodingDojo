from flask import Flask, session, render_template, redirect, request, flash
from flask_app import app


@app.route('/loginPageDoctor')
def loginPageDoctor():
    return render_template("/doctor/login.html")

@app.route('/dashboardPageDoctor')
def dashboardPageDoctor():
    return render_template("/doctor/dashboard.html")