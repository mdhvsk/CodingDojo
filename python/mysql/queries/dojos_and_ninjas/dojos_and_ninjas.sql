SET SQL_SAFE_UPDATES = 0;

INSERT into dojos(name)
VALUES 
	('Sunnyvale'),
    ('San Jose'),
    ('Mountain View');


    
DELETE from dojos WHERE name IN ("Sunnyvale", "San Jose", "Mountain View");

INSERT into dojos(name)
VALUES 
	('Santa Clara'),
    ('San Bruno'),
    ('Palo Alto');


INSERT into ninjas (first_name, last_name, age, dojos_id)
	VALUES
    ("Madhav", "Asok", 20, 37), 
    ("John", "Cena", 35, 37),
    ("Dave", "Chapelle", 45, 37);

INSERT into ninjas (first_name, last_name, age, dojos_id)
	VALUES
    ("Pat", "Mahomes", 20, 38), 
    ("John", "Trovolta", 35, 38),
    ("Dave", "Matthews", 45, 38);

INSERT into ninjas (first_name, last_name, age, dojos_id)
	VALUES
    ("Steph", "Curry", 20, 39), 
    ("John", "Adams", 35, 39),
    ("David", "Robinson", 45, 39);




DELETE from dojos WHERE id >39;
SELECT first_name, last_name, dojos_id from ninjas LEFT JOIN dojos ON ninjas.dojos_id = dojos.id WHERE dojos_id = 37;
SELECT first_name, last_name, dojos_id from ninjas LEFT JOIN dojos ON ninjas.dojos_id = dojos.id WHERE dojos_id = 39;

SELECT `name` from ninjas JOIN dojos on ninjas.dojos_id = dojos_id ORDER BY ninjas.id DESC LIMIT 1

