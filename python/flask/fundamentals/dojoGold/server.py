from flask import Flask, render_template, request, redirect, session, json
import random
from datetime import datetime
app = Flask(__name__)
app.secret_key = "secret stuff"

class Activity:

    def __init__(self, message, color):
        self.message = message
        self.color = color

@app.route('/')
def home():
    if 'count' in session:
        print("")
    else:
        session['count'] = 0

    if 'message' in session:
        print('')
    else:
        session['message'] = []

    print(session['count'])
    print(session['message'])
    return render_template('index.html', count = session['count'], activities = session['message'])


@app.route('/process_money', methods = ['POST'])
def process():
    # print(request.form)
    if 'casino' in request.form:
        rando = random.randint(-50,50)
        if rando < 0:
            message = f"Entered a casino and lost {abs(rando)} golds... Ouch.."
        else:
            message = f'Earned {rando} golds from the casino!'

    elif 'house'in request.form:
        rando = random.randint(2,5)
        message = f'Earned {rando} golds from the house! {datetime.now()}'
    elif 'cave'in request.form:
        rando = random.randint(5,10)
        message = f'Earned {rando} golds from the cave! {datetime.now()}'
    else: 
        rando = random.randint(10,20)
        message = f'Earned {rando} golds from the farm! {datetime.now()}'

    x = Activity(message, "red")
    session['count'] += rando
    session['message'].append(json.dumps(x))
    return redirect('/')



if __name__=="__main__":   
    app.run(debug=True) 
    session.clear()
    print("hi there")