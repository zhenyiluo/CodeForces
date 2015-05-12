package Round302;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-11.
 */
public class RoadImprovement {
    static int[] dp;
    static int[] ans;
    static ArrayList<Integer>[] g;
    public static final int MOD = (int)(1e9 + 7);
    public static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        g = new ArrayList[n];
        dp = new int[n];
        ans = new int[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i < n; i++){
            int fr = sc.nextInt() - 1;
            g[fr].add(i);
        }
        dfs(0);
        dfs0(0, 0);

        for(int i = 0; i < n; i++){
            pw.println(ans[i]);
        }
    }

    private static void dfs(int v) {
        dp[v] = 1;
        for(int i = 0; i < g[v].size(); i++){
            dfs(g[v].get(i));
            dp[v] = (int)((long) dp[v] * (dp[g[v].get(i)] + 1) % MOD);
        }
    }

    private static void dfs0(int v, int x) {
        ans[v] = (int)((long) dp[v] * (x + 1) % MOD);
        int m = g[v].size();
        int[] pref = new int[m + 1];
        int[] suf = new int[m + 1];
        pref[0] = (x + 1) % MOD;
        for(int i = 0; i < m; i++){
            pref[i+1] = (int) ((long)pref[i] * (dp[g[v].get(i)] + 1) % MOD);
        }
        suf[m] = 1;
        for(int i = m-1; i >= 0; i--){
            suf[i] = (int) ((long) suf[i+1] * (dp[g[v].get(i)] + 1) % MOD);
        }
        for(int i = 0; i < m; i++){
            dfs0(g[v].get(i), (int) ((long) pref[i] * suf[i+1] % MOD));
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new RoadImprovement().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
