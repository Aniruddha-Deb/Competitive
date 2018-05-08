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

        int len = ir.readInt();
        int ntc = ir.readInt();

        BitSet b1 = new BitSet( len );        
        BitSet b2 = new BitSet( len );

        while( ntc-- > 0 ) {
            String op = ir.readString();
            int n1 = ir.readInt();
            int n2 = ir.readInt();
            if( op.equals( "AND" ) ) {
                if( n1 == 1 ) b1.and( b2 );
                else b2.and( b1 );
            }
            else if( op.equals( "OR" ) ) {
                if( n1 == 1 ) b1.or( b2 );
                else b2.or( b1 );
            }
            else if( op.equals( "XOR" ) ) {
                if( n1 == 1 ) b1.xor( b2 );
                else b2.xor( b1 );
            }
            else if( op.equals( "FLIP" ) ) {
                if( n1 == 1 ) b1.flip( n2 );
                else b2.flip( n2 );
            }
            else {
                if( n1 == 1 ) b1.set( n2 );
                else b2.set( n2 );
            }
            ow.println( b1.cardinality() + " " + b2.cardinality() );
        }
    }     

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
