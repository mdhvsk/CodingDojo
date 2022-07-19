from flask_app.config.mysqlconnection import connectToMySQL

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.full_name = self.first_name + " "+ self.last_name
    
    @classmethod
    def get_all(cls):
        query = 'SELECT * FROM users;'
        result = connectToMySQL('users').query_db(query)
        # print(result)
        users = []
        for user in result:
            users.append(cls(user))
        # print(users)
        return users

    @classmethod
    def create(cls, data):
        query = "INSERT INTO users (first_name, last_name, email) VALUES (%(first_name)s, %(last_name)s, %(email)s);"

        userID = connectToMySQL("users").query_db(query,data)

        return userID

    @classmethod 
    def delete (cls, data):
        query = "DELETE FROM users WHERE id = %(id)s"
        print(query)
        connectToMySQL("users").query_db(query,data)
    
    @classmethod 
    def read_one (cls, data):
        query = "SELECT * FROM users WHERE id = %(id)s"
        print(query)
        result = connectToMySQL("users").query_db(query,data)
        print(result)

        # user = cls(result)
        # print(user)

        one_user = []
        for user in result:
            one_user.append(cls(user))
        print(one_user)

        return one_user

    @classmethod
    def edit(cls, data):
        query = "UPDATE users set first_name = %(first_name)s, last_name =  %(last_name)s, email = %(email)s WHERE %(id)s"
        print(query)
        result = connectToMySQL("users").query_db(query,data)




    

    
