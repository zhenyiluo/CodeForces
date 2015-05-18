package RCC2014Warmup;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class Football {
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n * k > (n * (n-1) / 2)){
            pw.println(-1);
            return;
        }

        HashSet<Integer>[] hs = new HashSet[n];
        for(int i = 0; i < n; i++){
            hs[i] = new HashSet<Integer>();
        }

        for(int i = 0; i < n; i++){
            int tmp = k;
            for(int j = 0; j < n && tmp > 0; j++){
                if(j != i && !hs[j].contains(i)){
                    hs[i].add(j);
                    tmp--;
                }
            }
        }
        pw.println(n * k);
        for(int i = 0; i < n; i++){
            for(int num : hs[i]){
                pw.println((i+1) + " " + (num+1));
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new Football().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
