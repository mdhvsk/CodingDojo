from flask_app.config.mysqlconnection import connectToMySQL
import re
from flask import flash


EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
class Email:

    def __init__(self, data):
        self.id = data['id']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @staticmethod
    def validate_email(email):
        is_valid = True

        if not EMAIL_REGEX.match(email['email']):
            flash('Invalid email address', 'email')
            is_valid = False
    
        return is_valid

    @classmethod
    def add_email(cls, email):
        query = "INSERT INTO email(email) VALUES(%(email)s);"
        newID = connectToMySQL('email_validation').query_db(query, email)
        return newID

    
    @classmethod
    def get_all(cls):
        query = "SELECT * from email"
        result = connectToMySQL('email_validation').query_db(query)

        emails = []
        for email in result:
            emails.append(cls(email))
        return emails

    @classmethod 
    def get_one_email(cls,data):
        query = "SELECT * FROM email WHERE id = %(id)s"
        result = connectToMySQL('email_validation').query_db(query, data)
        emails = []
        for email in result:
            emails.append(cls(email))
        return emails[0]
    




