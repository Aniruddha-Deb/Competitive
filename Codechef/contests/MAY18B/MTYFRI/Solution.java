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
            int k = ir.readInt();
 
            int sm = 0;
            int st = 0;
 
            PriorityQueue<Integer> m = new PriorityQueue<>( (i1,i2) -> -Integer.compare(i1, i2) );
            PriorityQueue<Integer> t = new PriorityQueue<>( (i1,i2) -> Integer.compare(i1, i2) );
 
            int[] a = new int[n];
 
            for( int i=0; i<n; i++ ) {
                a[i] = ir.readInt();
                if( i%2 == 0 ) {
                    sm += a[i];
                    m.add( a[i] );
                }
                else {
                    st += a[i];
                    t.add( a[i] );
                }
            }
 
            if( sm < st ) ow.println( "YES" );
            else {
                while( k-- > 0 ) {
                    // swap the largest element of motu with that of tomu
                    int motu = m.poll();
                    int tomu = t.poll();
 
                    sm = (sm-motu)+tomu;
                    st = (st-tomu)+motu;
 
                    m.add( tomu );
                    t.add( motu );
                    if( st > sm ) break;
                }
                if( st > sm ) ow.println( "YES" );
                else ow.println( "NO" );
            //     int diff = sm-st;
            //     for( int i=m.length-1,j=0; j<t.length&&k>0; i--,j++,k-- ) {
            //         int nm = m[i];
            //         int nt = t[j];
 
            //         int temp = m[i];
            //         m[i] = t[j];
            //         t[j] = temp;
 
            //         sm = (sm-nm)+nt;
            //         st = (st-nt)+nm;
            //         if( st > sm ) break;
            //     }
            //     if( st <= sm ) ow.println( "NO" );
            //     else ow.println( "YES" );
            }
 
            // ow.println( Arrays.toString( m ) );
            // ow.println( Arrays.toString( t ) );            
        }
    }     
 
    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
 