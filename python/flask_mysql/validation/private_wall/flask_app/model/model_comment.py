from flask_app.config.mysqlconnection import connectToMySQL


class Comment:
    def __init__(self, data):
        self.sender_id = data['sender_id']
        self.recipient_id = data['recipient_id']
        self.comment = data['comment']
        self.created_at = data['created_at']
        self.sender_name = data["first_name"]
        self.recipient_name = data["recipient.first_name"]

    
    @classmethod
    def getMessages(cls, data):
        # query = "SELECT * from users JOIN comments ON comments.recipient_id = users.id WHERE users.id = %(id)s"
        # query = "SELECT comments.sender_id, comments.comment, comments.created_at, comments.recipient_id from users JOIN comments ON comments.recipient_id = users.id WHERE comments.recipient_id = %(id)s"
        query = "SELECT * from comments LEFT JOIN users as sender ON comments.sender_id = sender.id RIGHT JOIN users as recipient ON comments.recipient_id = recipient.id WHERE comments.recipient_id = %(id)s;"
        result = connectToMySQL("private_wall").query_db(query, data)
        print(result)
        comments = []

        for comment in result:
            comments.append(cls(comment))
        return comments

    @staticmethod 
    def makeComment(data):
        query = "INSERT INTO comments(sender_id, recipient_id, comment) VALUES(%(sender_id)s, %(recipient_id)s, %(comment)s)"
        result = connectToMySQL("private_wall").query_db(query,data)
        return "YES"

    @staticmethod
    def deleteComment(data):
        # print(data)
        query = "DELETE FROM comments WHERE (sender_id = %(sender_id)s and recipient_id = %(recipient_id)s and comment = %(comment)s);"
        result = connectToMySQL("private_wall").query_db(query,data)
        return "YES"

