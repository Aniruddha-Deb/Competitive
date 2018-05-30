import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.Math.*;

class Solution {

    public static final int MOD = (int)10e9+7;

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

    class Group() {
        int[] cf = new int[4];
        int tc = 0;
        List<String> names;

        Group( String n1, int c1, String n2, int c2 ) {
            names = new ArrayList<>((int)10e3);
            names.add( n1 );
            names.add( n2 );
            tc += 2;
            cf[c1]++;
            cf[c2]++;
        }

        void addChild( String n, int c ) {
            names.add( n );
            tc++;
            cf[c]++;
        }

        boolean fits( int c, int max, int cn ) {
            return t+1 < max && cf[c]+1<cn;
        }

        boolean check( int[] mc, int max, int min ) {
            if( tc > max || tc < min ) return false;
            for( int i=1; i<=3; i++ ) {
                if( cf[i] > mc[i] ) return false;
            }
            return true;
        }

        boolean contains( String child ) {
            return names.contains( child );
        }
    }

    void run() throws Exception {
        InputReader ir = new InputReader( System.in );
        OutputWriter ow = new OutputWriter( System.out );

        int n = ir.readInt();
        int m = ir.readInt();
        int a = ir.readInt();
        int b = ir.readInt();
        int f = ir.readInt();
        int s = ir.readInt();
        int t = ir.readInt();

        int[] max = { 0, f, s, t };

        Map<String, Integer> students = new HashMap<>(n);
        Map<String, Boolean> addedInAGroup = new HashMap<>(n);
        for( int i=0; i<n; i++ ) {
            String sname = ir.readString();
            int sClass = ir.readInt();
            students.put( sname, sClass );
            addedInAGroup.put( sname, false );
        }

        List<Group> groups = new ArrayList<>((int)(5*10e2));

        for( int i=0; i<m; i++ ) {
            String n1 = ir.readString();
            String n2 = ir.readString();
            if( !addedInAGroup.get( n1 ) && !addedInAGroup.get( n2 ) ) {
                groups.add( new Group( n1, students.get( n1 ), n2, students.get( n2 ) ) );
                addedInAGroup.put( n1, true );
                addedInAGroup.put( n2, true );
            }
            else if( !addedInAGroup( n1 ) ) {
                for( Group g : groups ) {
                    if( g.contains( n2 ) && fits( students.get( n1 ), b, max[students.get( n1 )] ) ) {
                        g.addChild( n1, students.get( n1 ) );
                    }
                }
            }
            else if( !addedInAGroup( n2 ) ) {
                for( Group g : groups ) {
                    if( g.contains( n1 ) && fits( students.get( n2 ) b, max[students.get( n2 )] ) ) {
                        g.addChild( n2, students.get( n2 ) );
                    }
                }
            }
        }

        for( Group g : groups ) {
            if( !g.check( max, b, a ) ) groups.remove( g );
        }
        Collections.sort( groups, (g1, g2) -> return Integer.compare( g1.tc, g2.tc ) );
        for( String s : groups.get( groups.size()-1 ) ) {
            ow.println( s );
        }

    }     

    public static void main( String args[] ) throws Exception { new Solution().run(); }
}
