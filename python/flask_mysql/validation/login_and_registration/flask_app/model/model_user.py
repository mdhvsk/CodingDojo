from flask_app.config.mysqlconnection import connectToMySQL
import re 
from flask import flash
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')


class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']

    @staticmethod
    def validateRegisterForm(data):
        is_valid = True
        if len(data['first_name']) < 2 or data['first_name'].isalpha() == False:
            flash("First name must contain only letters with at least 2 letters", 'register')
            is_valid = False
        if len(data['last_name']) < 2 or data['last_name'].isalpha() == False:
            flash("Last name must contain only letters with at least 2 letters", 'register')
            is_valid = False
        if not EMAIL_REGEX.match(data['email']):
            flash('Invalid email address', 'register')
            is_valid = False
        if len(data['password']) < 8:
            flash("Password must be at least 8 characters", 'register')
            is_valid = False
        if data['password'] != data['confirmPassword']:
            flash("Passwords do not match", 'register')
            is_valid = False
        return is_valid
    
    @classmethod 
    def registerUser(cls, data):
        query = "INSERT INTO users(first_name, last_name, email, password) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s)"
        newID = connectToMySQL("login_and_registration").query_db(query, data)
        return newID

    @staticmethod
    def getUserByEmail(data):
        query = "SELECT * from users WHERE email = %(email)s"
        result = connectToMySQL("login_and_registration").query_db(query, data)
        
        if len(result) == 0:
            return False

        return result[0]

    