package Round302;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-11.
 */
public class E {
    public static final int INF = (int)1e9;
    public static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
        }
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ;j++){
                a[i][j] = sc.nextInt();
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int j = 0; j < m; j++){
            int[] mask = new int[26];
            int[] total = new int[26];
            int[] max = new int[26];
            for(int i = 0; i < n; i++){
                int x = s[i].charAt(j) - 'a';
                mask[x] |= 1 << i;
                total[x] += a[i][j];
                max[x] = Math.max(a[i][j], max[x]);
                int tmpMask = 1 << i;
                int cost = a[i][j];
                for(int k = dp.length - 1; k >=0; k--){
                    if(dp[k] < INF){
                        dp[k | tmpMask] = Math.min(dp[k | tmpMask], dp[k] + cost);
                    }
                }
            }

            for(int c = 0; c < 26; c++){
                if(mask[c] != 0){
                    int newCost = total[c] - max[c];
                    for(int k = dp.length - 1; k >=0; k--){
                        if(dp[k] < INF){
                            dp[k | mask[c]] = Math.min(dp[k | mask[c]], dp[k] + newCost);
                        }
                    }
                }
            }
        }

        pw.println(dp[dp.length-1]);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new E().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
