package Round302;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-10.
 */
public class D {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new D().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }

    private void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            g[from].add(to);
            g[to].add(from);
        }
        int[][] dist = new int[n][n];
        int[] q = new int[n];
        for(int v = 0; v < n; v++){
            bfs(v, dist[v], q, g);
        }
        int ans = Integer.MAX_VALUE;
        int s1 = sc.nextInt() - 1;
        int t1 = sc.nextInt() - 1;
        int l1 = sc.nextInt();
        int s2 = sc.nextInt() - 1;
        int t2 = sc.nextInt() - 1;
        int l2 = sc.nextInt();
        if(dist[s1][t1] > l1 || dist[s2][t2] > l2){
            pw.println(-1);
            return;
        }
        ans = Math.min(ans, dist[s1][t1] + dist[s2][t2]);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dist[s1][i] + dist[i][j] + dist[j][t1] <= l1 && dist[s2][i] + dist[i][j] + dist[j][t2] <= l2){
                    ans = Math.min(ans, dist[s1][i] + dist[i][j] + dist[j][t1] + dist[s2][i] + dist[j][t2]);
                }
                if(dist[s1][i] + dist[i][j] + dist[j][t1] <= l1 && dist[s2][j] + dist[j][i] + dist[i][t2] <= l2){
                    ans = Math.min(ans, dist[s1][i] + dist[i][j] + dist[j][t1] + dist[s2][j] + dist[i][t2]);
                }
            }
        }
        pw.println(m - ans);
    }

    private void bfs(int v, int[] dist, int[] q, ArrayList<Integer>[] g) {
        Arrays.fill(dist, -1);
        dist[v] = 0;
        int qIt = 0;
        int qSz = 1;
        q[0] = v;
        while(qIt < qSz){
            int u = q[qIt++];
            for(int to : g[u]){
                if(dist[to] == -1){
                    dist[to] = dist[u] + 1;
                    q[qSz++] = to;
                }
            }
        }
    }
}
