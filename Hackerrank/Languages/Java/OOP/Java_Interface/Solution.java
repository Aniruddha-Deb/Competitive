class MyCalculator implements AdvancedArithmetic {
    @Override
    public int divisor_sum( int n ) {
        int sum = 0;
        for( int i=1; i<=(n/2); i++ ) {
            if( n%i == 0 ) {
                sum += i;
            }
        }
        sum += n;
        return sum;
    }
}
