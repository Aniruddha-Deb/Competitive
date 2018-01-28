if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    l = list( arr )
    l.sort()
    l.reverse()
    max = l[0]
    i=1
    while l[i] == max:
        i += 1
    print( l[i] )
    
    
