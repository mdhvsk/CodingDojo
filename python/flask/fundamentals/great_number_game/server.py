from flask import Flask, render_template, request, redirect, session
import random

app = Flask(__name__)
app.secret_key = "secret stuff"


@app.route('/')
def index():
    if 'target' in session:
        print("already target")
    else:
        session['target'] = random.randint(1,100)
    session['attemptTally'] = 0
    print(session['target'])
    return render_template('index.html')

@app.route('/compare', methods = ['POST'])
def compare():
    # print(request.form)
    session['current'] = request.form['attempt']
    # print(session['current'])
    return redirect('/answer')

@app.route('/answer')
def answer():
    if (int(session['current']) == int(session['target'])):
        return render_template('play_again.html', correct = "Correct!" )

    if (int(session['current']) < int(session['target'])):
        session['response'] = "Too low!"
        return render_template('compare.html', response = session['response'])

    elif (int(session['current']) > int(session['target'])):
        session['response'] = "Too high!"
        return render_template('compare.html', response = session['response'])



@app.route('/play_again', methods = ['POST'])
def play_again():
    session.pop('target')
    return redirect('/')

if __name__=="__main__":   
    app.run(debug=True)   