import java.io.*;
import java.util.*;

public class EKGB2 {
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
        int x = sc.nextInt() -1;
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt() -1;
        }
        
        boolean[] possible = new boolean[n+1];
        possible[0] = true;
        
        boolean[] tails = new boolean[n];
        Arrays.fill(tails, true);
        for(int i = 0; i <n; i++){
            if(a[i] >= 0){
                tails[a[i]] = false;
            }
        }
        for(int i = 0; i < n; i++){
            if(tails[i]){
                int at = i;
                int len = 0;
                boolean foundMe = false;
                while(at >= 0){
                    if(at == x){
                        foundMe = true;
                    }
                    len ++;
                    at = a[at];
                }
                if(!foundMe){
                    for(int k = n - len; k>= 0; k --){
                        if(possible[k]){
                            possible[k + len] = true;
                        }
                    }
                }
            }
        }
        
        int offSet = 0;
        while(x >= 0){
            offSet ++;
            x = a[x];
        }
        
        for(int i = 0; i < n; i++){
            if(possible[i]){
                pw.println(i+offSet);
            }
        }
    }
}
