package Round221;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-16.
 */
public class IOU {
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] ins = new ArrayList[n];
        ArrayList<Integer>[] ous = new ArrayList[n];
        for(int i = 0; i < n; i++){
            ins[i] = new ArrayList<Integer>();
            ous[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            ins[b].add(c);
            ous[a].add(c);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int num : ins[i]){
                sum += num;
            }
            for(int num : ous[i]){
                sum -= num;
            }
            if(sum > 0){
                ans += sum;
            }
        }
        pw.println(ans);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new IOU().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
