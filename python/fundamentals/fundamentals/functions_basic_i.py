#1 prints nothing, prints 5
print("Problem 1: ")
def number_of_food_groups():
    return 5
print(number_of_food_groups())

print("Problem 2: ")

#2 #eroor since first function not defined
def number_of_military_branches():
    return 5
# print(number_of_days_in_a_week_silicon_or_triangle_sides() + number_of_military_branches())

print("Problem 3: ")

#3 prints 5
def number_of_books_on_hold():
    return 5
    return 10
print(number_of_books_on_hold())

print("Problem 4: ")

#4 #prints 5
def number_of_fingers():
    return 5
    print(10)
print(number_of_fingers())
print("Problem 5: ")


#5 prints 5 in function but x doesn't get assigned anything
def number_of_great_lakes():
    print(5)
x = number_of_great_lakes()
print(x)


#6 Error since the function doesn't return any values, so add functions will be null
# def add(b,c):
#     print(b+c)
# print(add(1,2) + add(2,3))


#7 prints  25
print("Problem 7: ")

def concatenate(b,c):
    return str(b)+str(c)
print(concatenate(2,5))

print("Problem 8: ")

#8 prints 100 within function then returns 10 to then be printed
def number_of_oceans_or_fingers_or_continents():
    b = 100
    print(b)
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(number_of_oceans_or_fingers_or_continents())

print("Problem 9: ")

#9 returns 7 then printed, returns 14 then printed, returns 7 and 14 summed to 21 then printed
def number_of_days_in_a_week_silicon_or_triangle_sides(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3))
print(number_of_days_in_a_week_silicon_or_triangle_sides(5,3))
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3) + number_of_days_in_a_week_silicon_or_triangle_sides(5,3))

print("Problem 10: ")

#10 prints 8
def addition(b,c):
    return b+c
    return 10
print(addition(3,5))

print("Problem 11: ")

#11 prints 500 --> 500 --> 300 (function foobar())--> 500
b = 500
print(b)
def foobar():
    b = 300
    print(b)
print(b)
foobar()
print(b)
print("Problem 12: ")


#12 prints 500 --> 500 --> 300 (function foobar())--> 500
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
foobar()
print(b)

print("Problem 13: ")

#13 prints 500 --> 500 --> 300 (function foobar())--> 300 (reassigned b)
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
b=foobar()
print(b)

print("Problem 14: ")

#14 prints 1 then calls bar prints 3 then prints 2
def foo():
    print(1)
    bar()
    print(2)
def bar():
    print(3)
foo()

print("Problem 15: ")

#15 calls foo, prints 1 calls bar prints 3 returns 5 to x in foo, prints 5, returns 10 to y prints 10
# print: 1 --> 3 --> 5 -->10
def foo():
    print(1)
    x = bar()
    print(x)
    return 10
def bar():
    print(3)
    return 5
y = foo()
print(y)