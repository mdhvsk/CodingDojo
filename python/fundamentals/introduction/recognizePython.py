num1 = 42 #variable declaration, integer
num2 = 2.3 #variable declaration, float
boolean = True, #variable declaration, boolean
string = 'Hello World' #variable declaration, string
pizza_toppings = ['Pepperoni', 'Sausage', 'Jalepenos', 'Cheese', 'Olives'] #variable declaration, list
person = {'name': 'John', 'location': 'Salt Lake', 'age': 37, 'is_balding': False} #variable declaration, dictionary
fruit = ('blueberry', 'strawberry', 'banana') # variable declaration, tuple
print(type(fruit))# print, type check
print(pizza_toppings[1]) #print, access value, list
pizza_toppings.append('Mushrooms') #add value, list
print(person['name']) #access value, dictionary
person['name'] = 'George' #change value, dictionary
person['eye_color'] = 'blue' #change value, dictionary
print(fruit[2]) #print, access value list

if num1 > 45:  #conditional if else and print
    print("It's greater")
else:
    print("It's lower")

if len(string) < 5: #conditional if, elif, else, length of string, print 
    print("It's a short word!")
elif len(string) > 15:
    print("It's a long word!")
else:
    print("Just right!")

for x in range(5):  #for loop and print
    print(x)
for x in range(2,5): #for loop start, stop and print
    print(x)
for x in range(2,10,3): #for loop start, stop, and increment and print
    print(x)
x = 0
while(x < 5): #while loop stop, increment, print
    print(x)
    x += 1

pizza_toppings.pop() #list delete value
pizza_toppings.pop(1) #list delete value

print(person) #print value, dictionary
person.pop('eye_color') #dictionary delete value
print(person) #Print value, dictionary

for topping in pizza_toppings: #for loop with nested if statement, continue, log statement, break
    if topping == 'Pepperoni':
        continue
    print('After 1st if statement')
    if topping == 'Olives':
        break

def print_hello_ten_times(): #function
    for num in range(10): #for loop stop
        print('Hello') #log statement

print_hello_ten_times() #call function

def print_hello_x_times(x): #function, argument
    for num in range(x): #for loop, variable declaration, stop
        print('Hello') #log statement

print_hello_x_times(4) #call function, argument, 

def print_hello_x_or_ten_times(x = 10): #define function, argument
    for num in range(x): #for loop, variable declaration, stop
        print('Hello') #log statement

print_hello_x_or_ten_times() #function call
print_hello_x_or_ten_times(4) #function call


"""
Bonus section
"""

# print(num3) #Name error
# num3 = 72 #variable declaration
# fruit[0] = 'cranberry' #Type error tuple does not support item assignment
# print(person['favorite_team']) Key error favorite tem
# print(pizza_toppings[7]) #IndexError 
#   print(boolean) #indentation error
# fruit.append('raspberry') #Attribute error tuple not appendable
# fruit.pop(1) #attribute error tuple not changable