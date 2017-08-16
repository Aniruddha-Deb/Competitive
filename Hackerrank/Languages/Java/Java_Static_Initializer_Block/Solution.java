// Code already present for creation of class and imports
    static int B = -1, H = -1;
    static boolean flag = false;

    static {
        Scanner sc = new Scanner( System.in );
        B = sc.nextInt();
        H = sc.nextInt();
        if( B <= 0 || H <= 0 ) {
            System.out.println( "java.lang.Exception: Breadth and height must be positive" );
        }
        else {
            flag = true;
        }
    }
// main method also present
