import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import java.math.*;

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

    public static void main( String args[] ) throws IOException {
        InputReader ir = new Main().new InputReader( System.in );
        OutputWriter ow = new Main().new OutputWriter( System.out );

        int numTestCases = ir.readInt();
        
        while( numTestCases > 0 ) {
            String s = ir.readString();
            int n = ir.readInt();

            int[] a = new int[s.length()];
            int[] b = new int[s.length()];
            int[] delta = new int[s.length()];

            int prevA = 0, prevB = 0;
            long sum = 0;
            for( int i=0; i<s.length(); i++ ) {
                char c = s.charAt(i);
                a[i] = prevA;
                b[i] = prevB;
                if( c == 'a' ) {
                    a[i] = prevA+1;
                    prevA = a[i];
                }
                else {
                    b[i] = prevB+1;
                    prevB = b[i];
                }
                delta[i] = a[i]-b[i];
                if( delta[i] > 0 ) sum++;
            }

            int lnum = delta[s.length()-1];

            // TODO gen testcases and test this out.

            if( lnum > 0 ) {
                int numIters = 1;
                while( Arrays.stream( delta ).anyMatch( i -> i<=0 ) && numIters <= n ) {
                    numIters++;
                    for( int i=0; i<delta.length; i++ ) {
                        delta[i]++;
                        if( delta[i] > 0 ) sum++;
                    }
                }
                ow.println( (n-numIters)*s.length() + sum );
            }
            else if( lnum == 0 ) {
                ow.println( n*sum );
            }
            else {
                int numIters = 1;
                while( Arrays.stream( delta ).anyMatch( i -> i>0 ) && numIters <= n ) {
                    numIters++;
                    for( int i=0; i<delta.length; i++ ) {
                        delta[i]--;
                        if( delta[i] > 0 ) sum++;
                    }
                }
                ow.println( sum );
            }
 
            numTestCases--;
        }
    }
}
