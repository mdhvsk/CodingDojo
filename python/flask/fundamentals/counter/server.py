from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "secret stuff"


@app.route('/')
def home():
    if 'counter' in session:
        print('key exists!')
        session['counter'] += 1

    else:
        session['counter'] = 1
    if 'visits' in session:
        print('key exists!')
        session['visits'] += 1

    else:
        session['visits'] = 1


    return render_template("index.html", count = session['counter'], visits = session['visits'])

@app.route('/counter', methods = ['POST'])
def counter():
    print(session['counter'])
    return redirect('/')

@app.route('/plus2', methods = ['POST'])
def plus2():
    session['counter'] += 1
    print(session['counter'])

    return redirect('/')

@app.route('/destroy_session', methods = ['POST'])
def destroy():
    print(request.form)
    session.pop('counter')
    print(request.form)
    return redirect('/')

if __name__=="__main__":   
    app.run(debug=True)    