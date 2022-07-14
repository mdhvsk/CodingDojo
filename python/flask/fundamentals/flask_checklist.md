# Flask Setup

## pre rec

```
pip install pipenv
```

## Checklist:

- Create a folder/dir for your assignment
- Navigate into that folder
- create your virtual env

```
pipenv install flask
```

- `WARNING` check for the files "pipfile" and "pipfile.lock"
    - If you don't these need to be fixed right away
- Launch the virtual env 
```
pipenv shell
```
- create a server.py file
```python
from flask import Flask  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"
@app.route('/')          # The "@" decorator associates this route with the function immediately following
def hello_world():
    return 'Hello World!'  # Return the string 'Hello World!' as a response
if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.


```




