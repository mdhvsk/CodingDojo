from array import ArrayType
from multiprocessing.reduction import AbstractReducer


def countDown(start):
    descent = []
    while start >= 0:
        descent.append(start)
        start -=1
    return descent
    # newDescent = []
    # for i in range(start, -1, -1):
    #     print(i)
    #     newDescent.append(i)

    # print(newDescent)

x= countDown(11)
# print(x)
# print(y)

# Problem 2
def print_and_return(x):
    print(x[0])
    return(x[1])


y = print_and_return([3,5])
print(y)

#Problem 3

def first_plus_length(array):
    return array[0] + len(array)

#problem 4

def values_greater_than_second(oldArray):
    if len(oldArray) < 2:
        return False
    cap = oldArray[1]
    newArray = []
    for i in oldArray:
        if i>cap:
            newArray.append(i)
    print(len(newArray))
    return newArray

print(values_greater_than_second([5,2,3,2,1,4]))

def thisLength_thatValue(size, value):
    array = [value] * size
    return array

print(thisLength_thatValue(6,2))








