import java.io.*;
import java.util.*;

import static java.lang.Math.*;

class Main {

    // FastIO
    class InputReader {
         
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public int[] readIntArray( int n ) {
            int[] x = new int[n];
            for( int i=0; i<n; i++ ) {
                x[i] = readInt();
            }
            return x;
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public String next() {
            return readString();
        } 
    }
 
    class OutputWriter {
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
 
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
 
        public void print(Object...objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i].toString());
            }
            writer.flush();
        }
 
        public void println(Object...objects) {
            print(objects);
            print( "\n" );
        }
 
        public void close() {
            writer.close();
        }
 
        public void flush() {
            writer.flush();
        }
     
    }

    class Pair {
        int n1, n2;
        public Pair( int n1, int n2 ) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public boolean equals( Object x ) {
            Pair p = (Pair)x;
            return ( p.n1 == n1 || p.n1 == n2 ) && (p.n2==n1||p.n2==n2);
        }
    }     

    public static void main( String args[] ) throws IOException {
        InputReader ir = new Main().new InputReader( System.in );
        OutputWriter ow = new Main().new OutputWriter( System.out );

        int numTestCases = ir.readInt();
        
        while( numTestCases > 0 ) {
            int n = ir.readInt();
            int[] a = ir.readIntArray( n );
            Set<Integer> nums = new HashSet<>();
            for( int i=0; i<n; i++ ) {
                nums.add( a[i] );
            }

            Set<String> uniquePairs = new HashSet<String>();

            for( int i=0; i<n; i++ ) {
                for( int j=i+1; j<n; j++ ) {
                    if( Math.abs( a[i]%2 ) == Math.abs( a[j]%2 ) ) {
                        int avg = (a[i]+a[j])/2;
                        if( nums.contains( avg ) ) {
                            int[] y = {i, j};
                            Arrays.sort( y );
                            uniquePairs.add( Arrays.toString(y) );
                        }
                    }
                }
            }

            ow.println( uniquePairs.size() );

            numTestCases--;
        }
    }
}
