package Round243;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-16.
 */
public class SerejaAndSwaps {
    public final static int INF = (int)(1e9+10);
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int ans = -INF;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                ans = Math.max(ans, calc(i, j, a, k));
            }
        }
        pw.println(ans);
    }

    public static int calc(int l, int r, int[] b, int k){
        int sum = 0;
        int[] a = b.clone();
        for(int i = l; i <= r; i++){
            sum += a[i];
        }

        for(int i = 0; i < k; i++){
            int insideNum = INF;
            int insidePos = -1;
            int outsideNum = -INF;
            int outsidePos = -1;
            for(int j = 0; j < a.length; j++){
                if(j < l || j > r){
                    if(a[j] > outsideNum){
                        outsideNum = a[j];
                        outsidePos = j;
                    }
                }else{
                    if(a[j] < insideNum){
                        insideNum = a[j];
                        insidePos = j;
                    }
                }
            }
            if(insidePos != -1 && outsidePos != -1){
                int delta = outsideNum - insideNum;
                if(delta > 0){
                    swap(a, insidePos, outsidePos);
                    sum += delta;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return sum;
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new SerejaAndSwaps().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
