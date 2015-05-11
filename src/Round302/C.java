package Round302;

import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Created by Zhenyi Luo on 15-5-10.
 */
public class C {
    public void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int b = sc.nextInt();
        int mod = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int[][] dp = new int[m+1][b+1];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k <= b; k++){
                    int newBugs = k + a[i];
                    if(newBugs <= b){
                        dp[j + 1][newBugs] = (dp[j + 1][newBugs] + dp[j][k]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i <= b; i++){
            ans = (ans + dp[m][i]) % mod;
        }
        pw.println(ans);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new C().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
