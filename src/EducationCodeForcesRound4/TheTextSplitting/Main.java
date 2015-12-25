import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.next();
            solve(n, p, q, s, pw);

        }
        sc.close();
        pw.flush();
        pw.close();

    }

    private static void solve(int n, int p, int q, String s, PrintWriter pw){
        for(int i = 0; i * p <= n; i++){
            if((n - i * p) % q == 0){
                int j = (n - i * p) / q;
                pw.println(i + j);
                for(int k = 0; k < i; k++){
                    pw.println(s.substring(k* p, (k+1) * p));
                }
                for(int k = 0; k < j; k++){
                    pw.println(s.substring(i * p + k * q, i * p +(k+1) * q));
                }
                return;
            }
        }
        pw.println(-1);
    }

}