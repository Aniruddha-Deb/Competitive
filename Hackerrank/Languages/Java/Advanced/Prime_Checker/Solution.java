import static java.lang.System.in;

class Prime {
    
    void checkPrime( int... n ) {
        for( int x : n ) {
            int numFactors = 0;
            for( int i=1; i<=x/2; i++ ) {
                if( x%i == 0 ) {
                    numFactors++;
                }
            }
            if( numFactors == 1 ) {
                System.out.print( x + " " );
            }
        }
        System.out.println();
    }
}
