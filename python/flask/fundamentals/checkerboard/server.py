from flask import Flask, render_template
app = Flask(__name__)


@app.route('/')
def defaultCheckerboard():
    return render_template('standardCheckerboard.html')

@app.route('/<int:x>/<int:y>')
def xy(x,y):
    return render_template('xy.html', x = x, y = y)

@app.route('/<int:x>/<int:y>/<first>/<second>')
def xy(x,y, first, second):
    return render_template('xy.html', x = x, y = y, color1 = first, color2 = second)

if __name__ == "__main__":
    app.run(debug=True)