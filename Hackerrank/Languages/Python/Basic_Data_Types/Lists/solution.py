if __name__ == '__main__':
    list = []
    N = int( input() )
    for i in range( 0, N ):
        cmd = input().split()
        if cmd[0] == "insert" :
            list.insert( int(cmd[1]), int(cmd[2]) )
        elif cmd[0] == "print":
            print( list )
        elif cmd[0] == "remove":
            list.remove( int(cmd[1]) )
        elif cmd[0] == "append":
            list.append( int(cmd[1]) )
        elif cmd[0] == "sort":
            list.sort()
        elif cmd[0] == "pop":
            list.pop()
        elif cmd[0] == "reverse":
            list.reverse()
        
