import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;

class Solution {

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

        int numTestCases = ir.readInt();
        
        while( numTestCases > 0 ) {
            int[][] am = new int[100][6];
            for( int i=1; i<100; i++ ) {
                for( int j=0; j<6 ; j++ ) {
                    if( i+(6-j)<=100 )
                    am[i][j] = i+(6-j);
                }
            }
            
            int nl = ir.readInt();            
            for( int i=0; i<nl; i++ ) {
                int n1 = ir.readInt();
                int n2 = ir.readInt();
                for( int j=n1-1,k=5; j>=n1-6 && j > 0; j--,k-- ) {
                    am[j][k] = n2;
                }
                for( int j=0; j<6; j++ ) {
                    am[n1][j] = 0; 
                }
            }
            
            int ns = ir.readInt();
            for( int i=0; i<ns; i++ ) {
                int n1 = ir.readInt();
                int n2 = ir.readInt();
                for( int j=n1-1,k=5; j>=n1-6 && j > 0; j--,k-- ) {
                    am[j][k] = n2;
                }
                for( int j=0; j<6; j++ ) {
                    am[n1][j] = 0; 
                }
            }
            
            ow.println( bfs( am ) );
            
            numTestCases--;
        }
    }
    
    int bfs( int[][] am ) {
        
        boolean[] visited = new boolean[101];
        
        int[] level = new int[101];
        
        LinkedList<Integer> visints = new LinkedList<>();
        visints.add( 1 );
        visited[1] = true;
        level[1] = 0;
        
        while( !visints.isEmpty() ) {
            int v = visints.pop();
            for( int i : am[v] ) {
                if( i == 100 ) {
                    visints = new LinkedList<>();
                    return level[v]+1;
                }
                if( !visited[i] ) {
                    level[i] = level[v]+1;
                    visints.add( i );
                    visited[i] = true;
                }
            }            
        }
        
        return -1;
    }

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
