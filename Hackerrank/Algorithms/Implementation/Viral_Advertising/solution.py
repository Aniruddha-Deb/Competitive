#!/bin/python3

import sys

def viralAdvertising(n):
    start = 5
    sum = 0
    prev = 0
    for i in range( 0, n ):
        prev = int( start / 2 )
        sum += prev
        start = prev * 3
    return sum

if __name__ == "__main__":
    n = int(input().strip())
    result = viralAdvertising(n)
    print(result)
