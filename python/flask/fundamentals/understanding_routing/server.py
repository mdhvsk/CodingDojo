from cmath import nan
from flask import Flask
import math 

app = Flask(__name__)
@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/dojo')
def dojo():
    return 'Dojo!'

@app.route('/say/<name>')
def say(name):
    # print(name)
    return ("Hi " +str(name)+'!')

@app.route('/repeat/<num>/<word>')
def repeat(num, word):
    if math.isnan(num):
        return "Sorry! No response. Try again."
    return ((word + " ") * num)

if __name__=="__main__":     
    app.run(debug=True) 