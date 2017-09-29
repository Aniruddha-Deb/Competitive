class Add {
    public void add( int... ints ) {
        int sum = 0;
        for( int i=0; i<ints.length; i++ ) {
            if( i == ints.length-1 ) {
                System.out.print( ints[i]+"=" );           
            }
            else {
                System.out.print( ints[i] + "+" );
            }
            sum += ints[i];
        }
        System.out.println( sum );
    }
}
