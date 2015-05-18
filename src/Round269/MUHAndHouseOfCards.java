package Round269;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class MUHAndHouseOfCards {
    public static void solve(Scanner sc ,PrintWriter pw){
        long n = sc.nextLong();
        int ans = 0;
        for(long i = 1; calCard(i) <= n; i++){
            if((n - calCard(i)) % 3 == 0){
                ans ++;
            }
        }
        pw.println(ans);
    }

    public static long calCard(long k){
        return k * (3*k + 1) / 2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new MUHAndHouseOfCards().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
