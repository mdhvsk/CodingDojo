# Setting up a Flask App

- Create project/assignment folder
- Navigate into folder

```
cd project_name
```
- install our virtual environment with flask, pymysql, flask-bcrypt

```
pipenv install flask pymysql flask-bcrypt

OR

python -m pipenv install flask pymysql flask-bcrypt
```

- `WARNING` --> look for __pipfile__ and __pipfile.lock()__
- launch shell

```
pipenv shell
```

- launch VS Code in the file location
- Build the file structure
    - project (folder)
        - flask_app (folder)
            - config (folder)
                - [mysqlconnection.py](#mysqlconnection.py)
            - controllers (folder)
                - [conroller_user.py](#controller_user.py)
            - models (folders)
                - [model_user.py](#model_user.py)
            - static (folders)
                - style.css
                - script.js

            - templates (folders)
                - index.html
                - table_name_action.html
                - user_edit.html
            - \_\_init__ (file)
        - pipfile
        - pipfile.lock
        - server.py

## mysqlconnection.py
```py
import pymysql.cursors
class MySQLConnection:
    def __init__(self, db):
        connection = pymysql.connect(host = 'localhost',
                                    user = 'root', # change the user and password as needed
                                    password = 'password', 
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

                cursor.execute(query, data)
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
                    print(query)
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





