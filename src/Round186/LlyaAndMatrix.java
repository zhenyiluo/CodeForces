package Round186;


import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-20.
 */
public class LlyaAndMatrix {
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        long[] a = new long[n];
        HashSet<Integer> hs = new HashSet<Integer>();
        int max = 0;
        for(int i = 0 ; (int)Math.pow(4, i) <= n; i++){
            hs.add((int)Math.pow(4, i));
            max = Math.max(max, i);
        }
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        long res = 0;
        int count = max+1;
        for(int i = 0; i <n; i++){
            res += a[n-i-1] * count;
            if(hs.contains(i+1)){
                count--;
            }
        }
        pw.print(res);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new LlyaAndMatrix().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
