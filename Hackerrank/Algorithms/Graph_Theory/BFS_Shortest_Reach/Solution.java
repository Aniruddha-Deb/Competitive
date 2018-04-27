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
            int v = ir.readInt();
            int e = ir.readInt();
            List<Integer>[] graph = new List[v];

            for( int i=0; i<v; i++ ) {
                graph[i] = new ArrayList<Integer>();
            }

            for( int i=0; i<e; i++ ) {
                int v1 = ir.readInt();
                int v2 = ir.readInt();
                graph[v1-1].add( v2-1 );
                graph[v2-1].add( v1-1 );
            }

            int sv = ir.readInt()-1;

            boolean[] visited = new boolean[v];
            int[] depth = new int[v];
            LinkedList<Integer> nodes = new LinkedList<Integer>();

            nodes.add( sv );
            visited[sv] = true;
            depth[sv] = 0;

            while( !nodes.isEmpty() ) {
                int n = nodes.pop();
                for( int i : graph[n] ) {
                    if( !visited[i] ) {
                        depth[i] = depth[n]+6;
                        nodes.add( i );
                        visited[i] = true;
                    }
                }
            }

            for( int i=0; i<v; i++ ) {
                if( i == sv ) continue;
                if( depth[i] == 0 ) ow.print( "-1 " );
                else ow.print( depth[i] + " " );
            }
            ow.println();
        }
    }     

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
