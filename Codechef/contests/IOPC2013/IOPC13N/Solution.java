import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.Math.*;

class Solution {

    public static final int MOD = 1000000007;

    // FastIO
    class InputReader {
         
        private DataInputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = new DataInputStream( stream );
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

    int[] parent;
    int u;
    void run() throws Exception {
        InputReader ir = new InputReader( System.in );
        OutputWriter ow = new OutputWriter( System.out );

        int n = ir.readInt();
        int q = ir.readInt();

        parent = new int[n];
        for( int i=0; i<n; i++ ) {
            parent[i] = i;
        }

        u = ir.readInt();
        for( int i=0; i<n-1; i++ ) {
            int x = ir.readInt();
            int y = ir.readInt();
            parent[y] = x;
        }

        while( q-- > 0 ) {
            int x = ir.readInt();
            int y = ir.readInt();

            if( xtoy( x,y ) ) ow.println( 1 );
            else if( ytox( x,y ) ) ow.println( -1 );
            else ow.println( 0 );
        }
    }

    boolean xtoy( int x, int y ) {
        if( parent[x] == y ) return true;
        while( x!=parent[x] && x != u ) {
            if( parent[x] == y ) return true;
            x = parent[x];
        }
        return false;
    }

    boolean ytox( int x, int y ) {
        if( parent[y] == x ) return true;
        while( y!=parent[y] && y != u ) {
            if( parent[y] == x ) return true;
            y = parent[y];
        }
        return false;        
    }

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
