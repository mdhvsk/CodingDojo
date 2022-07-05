# 1. TASK: print "Hello World"
print("Hello World")
# 2. print "Hello Noelle!" with the name in a variable
name = "Noelle"
myName = "Madhav"
print("Hello", name)	# with a comma
print("Hello " + name)	# with a +
print("Hello ", myName, "!", sep = '')
print("Hello " + myName +"!")
# 3. print "Hello 42!" with the number in a variable
name = 42
myNum = 7
print("Hello ",42,"!", sep = '')	# with a comma
print("Hello ",myNum, "!", sep = "")
print("Hello " + str(name) + "!")	# with a +	-- this one should give us an error!
print("Hello " + str(myNum) + "!")
# 4. print "I love to eat sushi and pizza." with the foods in variables

fave_food1 = "sushi"
fave_food2 = "pizza"
food1 = "gyros"
food2 = "pho"
print("I love to eat {} and {}.".format(fave_food1, fave_food2)) # with .format()
print(f"I love to eat {fave_food1} and {fave_food2}.") # with an f string
print("I love to eat {} and {}.".format(food1,food2))
print(f"I love to eat {food1} and {food2}.")
print("I love to eat %s and %s." %(food1,food2))
