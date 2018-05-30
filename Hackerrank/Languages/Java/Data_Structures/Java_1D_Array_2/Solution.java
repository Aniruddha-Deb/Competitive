import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int cpos, boolean[] visited) {
        visited[cpos] = true;
        if( cpos+1 >= game.length || cpos + leap >= game.length ) return true;
        boolean cwin = false;
        if( game[cpos+leap] == 0 && !visited[cpos+leap] ) cwin = canWin( leap, game, cpos+leap,visited );
        if( !cwin && game[cpos+1] == 0 && !visited[cpos+1] ) cwin = canWin( leap, game, cpos+1,visited );
        if( !cwin && cpos>0 && game[cpos-1] == 0 && !visited[cpos-1] ) cwin = canWin( leap, game, cpos-1,visited );
        return cwin;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            boolean[] visited = new boolean[n];
            Arrays.fill( visited, false );
            
            System.out.println( (canWin(leap, game,0,visited)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
