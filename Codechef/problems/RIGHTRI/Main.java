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

    public static void main( String args[] ) throws IOException {
        InputReader ir = new Main().new InputReader( System.in );
        OutputWriter ow = new Main().new OutputWriter( System.out );

        int numTestCases = ir.readInt();
        int nt = 0;
        
        while( numTestCases > 0 ) {
            int x1 = ir.readInt();
            int y1 = ir.readInt();
            int x2 = ir.readInt();
            int y2 = ir.readInt();
            int x3 = ir.readInt();
            int y3 = ir.readInt();

            double s1l = round( pow( sqrt( pow( x1-x2, 2 ) + pow( y1-y2, 2 ) ), 2 ) );
            double s2l = round( pow( sqrt( pow( x2-x3, 2 ) + pow( y2-y3, 2 ) ), 2 ) );
            double s3l = round( pow( sqrt( pow( x3-x1, 2 ) + pow( y3-y1, 2 ) ), 2 ) );

            double p1 = s1l + s2l - s3l;
            double p2 = s2l + s3l - s1l;
            double p3 = s3l + s1l - s2l;

            if( p1==0 || p2==0 || p3==0 ) {
                nt++;
            }            
            numTestCases--;
        }

        ow.println( nt );
    }
}
