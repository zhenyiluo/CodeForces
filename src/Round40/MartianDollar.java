import java.io.*;
import java.util.*;

public class MartianDollar {
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
        int b = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int maxProfit = b;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j< n; j++){
                int profit = b / a[i] * a[j] + b % a[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        pw.println(maxProfit);
    }
}
