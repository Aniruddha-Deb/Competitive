import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        
        int maxNKT = -1;
        int nt = 0;
        for( int i=0; i<topic.length; i++ ) {
            for( int j=i+1; j<topic.length; j++ ) {
                char[] c1 = topic[i].toCharArray();
                char[] c2 = topic[j].toCharArray();
                int nkt = 0;
                for( int k=0; k<c1.length; k++ ) {
                    if( c1[k] == '1' || c2[k] == '1' ) nkt++;
                }
                if( nkt > maxNKT ) {
                    maxNKT = nkt;
                    nt = 1;
                }
                else if( nkt == maxNKT ) nt++;
            }
        }
        return new int[]{maxNKT, nt};

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
