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

    void run() throws Exception {
        InputReader ir = new InputReader( System.in );
        OutputWriter ow = new OutputWriter( System.out );

        int ntc = ir.readInt();
        
        while( ntc-- > 0 ) {
            int a = ir.readInt();
            int b = ir.readInt();
            String binB = Integer.toBinaryString( b );
            int binBLen = binB.length();
            String binA = Integer.toBinaryString( a );
            int binALen = binA.length();

            int radix = (1<<binBLen)-(1<<binALen);

            // ow.println( "binB = " + binB );
            // ow.println( "binA = " + binA );
            // ow.println( "radix = " + radix );

            if( b == 0 ) ow.println( "-1" );
            else if( a != b ) {
                if( binB.endsWith( "1" ) ) ow.println( (freq(binB)-freq(binA)) );
                else {
                    int nops = binB.substring( binB.lastIndexOf( "1" ) ).length();
                    ow.println(  (nops+freq(binB)-freq(binA)-1) );
                }
            }
            else if( a == b ) ow.println( "0" );
        }
    }

    int freq( String binA ) {
        int ctr = 0;
        for( char c : binA.toCharArray() ) {
            if( c == '1' ) ctr++;
        }
        return ctr;
    }

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
