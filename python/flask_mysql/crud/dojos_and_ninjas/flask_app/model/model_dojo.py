from flask_app.config.mysqlconnection import connectToMySQL

class Dojo:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data["created_at"]
        self.updated_at = data["updated_at"]
        self.ninjas = []
        
    
    @classmethod
    def get_all_dojos(cls):
        query = "SELECT * FROM dojos"
        result = connectToMySQL('dojos_and_ninjas_schema').query_db(query)
        dojos = []
        for dojo in result:
            dojos.append(cls(dojo))
        return dojos

    @classmethod
    def create_dojo(cls, data):
        query = "INSERT INTO dojos(name) VALUES (%(name)s)"
        newDojoID = connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)
        return newDojoID

    @classmethod
    def get_one_dojo(cls, data):
        query = "SELECT * FROM dojos WHERE id = %(id)s"
        result = connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)
        dojo = []
        for one in result:
            dojo.append(cls(one))
        return dojo

    


    


