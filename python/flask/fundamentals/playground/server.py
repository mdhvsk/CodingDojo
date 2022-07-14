from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play/<times>/')
def hello_world(times):
    times = int(times)
    return render_template('index.html', num = times)

@app.route('/play/<times>/<color>')
def level3(times, color):
    return render_template('index.html', num = times, background = color)

if __name__ == "__main__":
    app.run(debug=True)

