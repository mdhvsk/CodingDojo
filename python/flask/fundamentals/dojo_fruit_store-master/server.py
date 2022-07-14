from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)  
app.secret_key = "secret stuff"

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    session['strawberry'] = request.form['strawberry']
    session['raspberry'] = request.form['raspberry']
    session['apple'] = request.form['apple']

    session['first_name'] = request.form['first_name']
    session['last_name'] = request.form['last_name']
    session['student_id'] = request.form['student_id']
    session['sum'] = (int(session['strawberry']) + int(session['raspberry'])+ int(session['apple']))

    print(f"Charging {session['first_name']} for {session['sum']}")
    return redirect('/checkoutInfo')


@app.route('/checkoutInfo')
def displayInfo():
    return render_template('checkout.html', strawberry = session['strawberry'],
    raspberry = session['raspberry'], apple = session['apple'], first_name =session['first_name'], 
    last_name = session['last_name'], student_id = session['student_id'], sum = session['sum'])


@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")

if __name__=="__main__":   
    app.run(debug=True)    