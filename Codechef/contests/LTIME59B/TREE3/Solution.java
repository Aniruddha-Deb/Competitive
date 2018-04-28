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
            int n = ir.readInt();

            List<List<Integer>> tree = new ArrayList<>();

            for( int i=0; i<n; i++ ) {
                tree.add( new ArrayList<Integer>() );
            }

            int[] edgeCount = new int[n];

            for( int i=0; i<n-1; i++ ) {
                int e1 = ir.readInt()-1;
                int e2 = ir.readInt()-1;
                tree.get(e1).add( e2 );
                edgeCount[e1]++;
            }

            long esum = 0;
            boolean nttd = false;
            for( int i=0; i<n; i++ ) {
                if( edgeCount[i] % 3 != 0 ) {
                    nttd = true;
                    break;
                }
            }
            if( nttd ) {
                ow.println( "NO" );
                break;
            }

            ow.println( "YES" );

            // not working

            LinkedList<Integer> list = new LinkedList<>();
            list.add( 0 );

            while( !list.isEmpty() ) {
                int k = list.pop();
                int len = tree.get(k).size();
                if( len != 0 && len%3 == 0 ) {
                    for( int i=0; i<len/3; i++ ) {
                        ow.print( k+1+" " );
                        for( int j=i*3; j<i*3+3; j++ ) {
                            ow.print( tree.get(k).get(j)+1+" " );
                        }
                    }
                    ow.println();
                }
                for( int i : tree.get(k) ) {
                    list.add(i);
                }
            }
        }
    }     

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
