import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by eric on 2015-12-19.
 */
public class TheBestGift {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        solve(sc, pw);
        sc.close();
        pw.flush();
        pw.close();
    }

    private static void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[m+1];
        for(int i = 0; i < n; i++){
            a[sc.nextInt()] ++;
        }
        long ret = 0;
        for(int i = 1; i < m; i++){
            for(int j = i+1; j < m+1; j++){
                ret += a[i] * a[j];
            }
        }
        pw.println(ret);
    }

}
