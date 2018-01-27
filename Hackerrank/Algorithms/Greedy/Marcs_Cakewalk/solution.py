#!/bin/python3

import sys

def marcsCakewalk(calorie):
    calorie.sort()
    calorie.reverse()
    sum = 0
    for i in range( 0, len(calorie) ):
        sum += (calorie[i] * (2**i))
    return sum

if __name__ == "__main__":
    n = int(input().strip())
    calorie = list(map(int, input().strip().split(' ')))
    result = marcsCakewalk(calorie)
    print(result)
