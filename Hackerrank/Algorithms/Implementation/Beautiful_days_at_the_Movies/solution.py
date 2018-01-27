#!/bin/python3

import sys

def beautifulDays(i, j, k):
    cntr = 0
    for num in range( i, j+1 ):
        rev = int( str( num )[::-1] )
        if (abs( rev-num )/k) % 1 == 0:
            cntr += 1
    return cntr

if __name__ == "__main__":
    i, j, k = input().strip().split(' ')
    i, j, k = [int(i), int(j), int(k)]
    result = beautifulDays(i, j, k)
    print(result)
