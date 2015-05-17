package Round152;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-16.
 */
public class ChillyWilly {
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        if(n < 3){
            pw.println(-1);
        }else if(n == 3){
            pw.println(210);
        }else{
            StringBuilder sb = new StringBuilder("");
            sb.append(1);
            for(int i = 0; i < n - 4; i++){
                sb.append(0);
            }
            sb.append(calcLastThreeDigits(n));
            pw.println(sb.toString());
        }
    }

    private static String calcLastThreeDigits(int n) {
        int remains = 1;
        for(int i = 0; i < n-1; i++){
            remains = (remains * 10) % 210;
        }
        Integer ans = 210 - remains;
        StringBuilder sb = new StringBuilder("");
        int zeroNum = 3 - ans.toString().length();
        for(int i = 0; i < zeroNum; i++){
            sb.append(0);
        }
        sb.append(ans);
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new ChillyWilly().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
