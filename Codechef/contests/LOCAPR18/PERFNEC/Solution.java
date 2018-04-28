import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.Math.*;

class Solution {

    public static final int MOD = 1000000007;

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

    // need a better solution here - got only 20 points
    void run() throws Exception {
        InputReader ir = new InputReader( System.in );
        OutputWriter ow = new OutputWriter( System.out );

        int[] beads = ir.readIntArray( 5 );
        int ntc = ir.readInt();

        while( ntc-- > 0 ) {
            int x = ir.readInt();
            int y = ir.readInt();

            if( x == 0 ) {
                ow.println( -1 );
            }
            else if( x == 1 ) {
                if( y+2 > 4 || y < -2 ) ow.println( -1 );
                else ow.println( beads[y+2] );
            }
            else {
                int min = Integer.MAX_VALUE;
                for( int i=0; i<5; i++ ) {
                    for( int j=i; j<5; j++ ) {
                        int n = i-2+j-2;
                        int m = beads[i] + beads[j];
                        if( ( n == y ) && m < min ) min = m; 
                    }
                }
                if( min == Integer.MAX_VALUE ) ow.println( -1 );
                else ow.println( min );
            }
        }
    }     

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
