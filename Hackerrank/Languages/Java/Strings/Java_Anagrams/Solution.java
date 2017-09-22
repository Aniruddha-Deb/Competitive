    static boolean isAnagram(String a, String b) {
        a = a.toUpperCase();
        b = b.toUpperCase();
        int[] alpha = new int[26];
        int[] beta  = new int[26];
        
        for( int i=0; i<a.length(); i++ ) {
            int index = (int)a.charAt( i )-65;
            alpha[index]++;
        }
        for( int i=0; i<b.length(); i++ ) {
            int index = (int)b.charAt( i )-65;
            beta[index]++;
        }
        
        for( int i=0; i<26; i++ ) {
            if( alpha[i] != beta[i] ) {
                return false;
            }
        }
        return true;
    }
