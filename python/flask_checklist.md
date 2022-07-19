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

- file structure list
    - assignment folder

- create a server.py file
```python
from flask import Flask, render_template # Import Flask to allow us to create our app
# import the class from friend.py
from friend import Friend

app = Flask(__name__)  # Create a new instance of the Flask class called "app"

@app.route("/")  # The "@" decorator associates this route with the function immediately following
def index():
    # call the get all classmethod to get all friends
    friends = Friend.get_all()
    print(friends)
    return render_template("index.html")
    
            

if __name__ == "__main__":  # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.
```

- mysqlconnections.py file 


``` python
import pymysql.cursors
class MySQLConnection:
    def __init__(self, db):
        connection = pymysql.connect(host = 'localhost',
                                    user = 'root', # change the user and password as needed
                                    password = 'root', 
                                    db = db,
                                    charset = 'utf8mb4',
                                    cursorclass = pymysql.cursors.DictCursor,
                                    autocommit = True)
        self.connection = connection
    def query_db(self, query, data=None):
        with self.connection.cursor() as cursor:
            try:
                query = cursor.mogrify(query, data)
                print("Running Query:", query)
     
                cursor.execute(query)
                if query.lower().find("insert") >= 0:
                    # if the query is an insert, return the id of the last row, since that is the row we just added
                    self.connection.commit()
                    return cursor.lastrowid
                elif query.lower().find("select") >= 0:
                    # if the query is a select, return everything that is fetched from the database
                    # the result will be a list of dictionaries
                    result = cursor.fetchall()
                    return result
                else:
                    # if the query is not an insert or a select, such as an update or delete, commit the changes
                    # return nothing
                    self.connection.commit()
            except Exception as e:
                # in case the query fails
                print("Something went wrong", e)
                return False
            finally:
                # close the connection
                self.connection.close() 
# this connectToMySQL function creates an instance of MySQLConnection, which will be used by server.py
# connectToMySQL receives the database we're using and uses it to create an instance of MySQLConnection
def connectToMySQL(db):
    return MySQLConnection(db)
```

- model_table_name.py file

``` python

# import the function that will return an instance of a connection
from mysqlconnection import connectToMySQL
# model the class after the friend table from our database
class Friend:
    def __init__( self , data ):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.occupation = data['occupation']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
    # Now we use class methods to query our database
    @classmethod
    def get_all(cls):
        query = "SELECT * FROM friends;"
        # make sure to call the connectToMySQL function with the schema you are targeting.
        results = connectToMySQL('first_flask').query_db(query)
        # Create an empty list to append our instances of friends
        friends = []
        # Iterate over the db results and create instances of friends with cls.
        for friend in results:
            friends.append( cls(friend) )
        return friends
            
```








