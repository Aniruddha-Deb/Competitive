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

        int na = ir.readInt();
        int np = ir.readInt();

        List<Integer>[] graph = new List[na];
        for( int i=0; i<na; i++ ) {
            graph[i] = new ArrayList<Integer>();
        }

        for( int i=0; i<np; i++ ) {
            int n1 = ir.readInt();
            int n2 = ir.readInt();
            graph[n1].add( n2 );
            graph[n2].add( n1 );
        }

        List<Integer> cs = new ArrayList<Integer>();

        boolean[] visited = new boolean[na];

        for( int i=0; i<na; i++ ) {
            if( visited[i] ) continue;
            cs.add( dfs( graph, i, visited ) );
        }

        long sum = 0;
        long result = 0;

        for( int i : cs ) {
            result += sum*i;
            sum += i;
        }

        ow.println( result );
    }     

    int dfs( List<Integer>[] graph, int i, boolean[] visited ) {
        if( visited[i] ) return 0;
        visited[i] = true;
        int s = 1;
        for( int x : graph[i] ) {
            if( visited[x] ) continue;
            s += dfs( graph, x, visited );
        }
        return s;
    }

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
