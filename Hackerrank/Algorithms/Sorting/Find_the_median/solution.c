#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int comp( const void* elem1, const void* elem2 ) {
    int f = *((int*)elem1);
    int s = *((int*)elem2);
    if (f > s) return  1;
    if (f < s) return -1;
    return 0;
}

int main() {

    int n;
    scanf( "%d\n", &n );
    int digits[n];
    for( int i=0; i<n; i++ ) {
        scanf( "%d ", &digits[i] );
    }
    
    qsort( digits, n, sizeof( n ), comp );    
    
    printf( "%d\n", digits[n/2] );
    
    return 0;
}
