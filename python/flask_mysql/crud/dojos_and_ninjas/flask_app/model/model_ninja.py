from flask_app.config.mysqlconnection import connectToMySQL

class Ninja:
    def __init__(self, data):
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.age = data['age']
        
    @classmethod
    def createNinja(cls, data):
        query = "INSERT INTO ninjas(first_name, last_name, age, dojos_id) VALUES(%(first_name)s, %(last_name)s, %(age)s, %(dojos_id)s)"
        newNinjaID = connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)
        return newNinjaID
    

    @classmethod 
    def getNinjas(cls,data):
        query = "SELECT * FROM ninjas LEFT JOIN dojos ON dojos.id = ninjas.dojos_id WHERE dojos.id = %(id)s"
        ninja_list = connectToMySQL('dojos_and_ninjas_schema').query_db(query, data)
        return ninja_list
