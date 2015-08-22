import java.io.*;
import java.util.*;

public class SymmetricAndTransitive {
    public static final int MOD = (int)(1e9 + 7);
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        solve(sc, pw);
        sc.close();
        pw.flush();
        pw.close();
    }
    
    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int[][] b = new int[n][n];
        b[0][0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    b[i][j] = b[i-1][i-1] % MOD;
                }else{
                    b[i][j] = (b[i][j-1] + b[i-1][j-1]) % MOD;
                }
            }
        }
        
        int[][] c = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            c[i][0] = 1;
            c[i][i] = 1;
        }
        
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < i; j++){
                c[i][j] = (c[i-1][j] + c[i-1][j-1]) % MOD;
            }
        }
        
        long ret = 1;
        for(int i = 1; i < n; i++){
            ret += ((long)c[n][i] * b[i][0]) % MOD;
            ret %= MOD;
        }
        pw.println(ret);
    }
}
