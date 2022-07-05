for i in range(151):
    print(i)

for i in range(5,1001,5):
    print(i)

for i in range(1,101):
    if i%10 == 0:
        print("Coding Dojo")
    elif i%5 ==0:
        print("Coding")
    else:
        print(i)

sumOfOdds = 0
for i in range(500001):
    if i%2 ==1:
        sumOfOdds += i
print(sumOfOdds)

i = 2018
while i > 0:
    print(i)
    i-=4

lowNum = 4
highNum = 36
mult = 7

for i in range(lowNum,highNum):
    if i%7==0:
        print(i)