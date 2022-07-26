from flask_app import app 
from flask_app.controllers.patient import controller_forms, controller_routes
from flask_app.controllers.doctor import controller_forms, controller_routes



if __name__ == "__main__":
    app.run(debug=True)