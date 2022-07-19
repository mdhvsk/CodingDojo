from unicodedata import name
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash

class Dojo:

    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.location = data['location']
        self.language = data['language']
        self.comment = data['comment']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        
    @classmethod
    def addUser(cls, data):
        query = "INSERT INTO dojos (name, location, language, comment) VALUES (%(name)s, %(location)s, %(language)s, %(comment)s);"

        userID = connectToMySQL("dojo_survey_schema").query_db(query,data)

        return userID

    @staticmethod
    def validate_dojos(data):
        is_valid = True
        if not data['name']:
            is_valid = False
            flash("Name is required")
        if not data['location'] or data['location'] == "--Select a Location--":
            is_valid = False
            flash("Location is required")
        if not data['language'] or data ['language'] == "--Select a Language--":
            is_valid = False
            flash("Language is required")
        if not data['comment']:
            is_valid = False
            flash("Comment is required")
        return is_valid
            


