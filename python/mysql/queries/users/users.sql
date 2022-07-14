
INSERT INTO users(first_name, last_name, email) 
VALUES 
	('madhav', 'asok', 'madhavasok@gmail.com'),
    ('john', 'cena', 'youcantseeme@hotmail.com'),
    ('dave', 'chapelle', 'darealdave@gmail.com');
    
SELECT * from users;

SELECT * from users WHERE email = 'madhavasok@gmail.com';
SELECT * from users ORDER BY id DESC LIMIT 1;

UPDATE users 
SET last_name = 'pancakes'
WHERE id = 3;

DELETE from users WHERE id = 2;

SELECT * from users ORDER BY first_name DESC; 
