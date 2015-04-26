package Round300;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Zhenyi Luo on 15-4-26.
 */
public class C {
    public void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[2];
        TreeSet<Integer> ts = new TreeSet<Integer>();
        int b = sc.nextInt();
        int c = sc.nextInt();
        a[0] = c;
        ts.add(b-1);
        int i = 1;

        int ans = 0;
        ans = Math.max(ans, a[0] + ts.first() - 0);

        while(i < m){
            b = sc.nextInt();
            c = sc.nextInt();
            a[1] = a[0];
            a[0] = c;
            ts.add(b-1);
            int first = ts.first();
            ts.remove(ts.first());
            int second = ts.first();
            if(second - first < Math.abs(a[1] - a[0])){
                pw.println("IMPOSSIBLE");
                return;
            }
            ans = Math.max(ans, (second - first - Math.abs(a[1] - a[0])) /2 + Math.max(a[0], a[1]));
            i++;
        }

        ans = Math.max(ans, a[0] + n - 1 - ts.last());
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
