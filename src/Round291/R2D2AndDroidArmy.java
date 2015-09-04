import java.util.*;
import java.io.*;

public class R2D2AndDroidArmy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNext()){
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();
    }
    
    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        int[] ret = new int[m];
        int maxLen = 0;
        int start = 0;
        int cur = 0;
        TreeMap<Integer, Integer>[] tms = new TreeMap[m];    
        for(int i = 0; i < m; i++){
            tms[i] = new TreeMap<Integer, Integer>();
        }
        while(cur <= n){
            int shoots = 0;
            if(tms[0].size() > 0){
                for(int i = 0; i < m; i++){
                    shoots += tms[i].lastKey();
                }
            }
            
            if(shoots <= k && cur - start > maxLen){
                maxLen = cur - start;
                for(int i = 0; i < m; i++){
                    ret[i] = tms[i].lastKey();
                }
            }
            if(cur == n){
                break;
            }
            if(shoots <= k){
                for(int i = 0; i < m; i++){
                    int val = a[cur][i];
                    if(!tms[i].containsKey(val)){
                        tms[i].put(val, 1);
                    }else{
                        tms[i].put(val, tms[i].get(val) + 1);
                    }
                }
                cur++;
            }else{
                for(int i = 0; i < m; i++){
                    int val = a[start][i];
                    tms[i].put(val, tms[i].get(val) -1);
                    if(tms[i].get(val) == 0){
                        tms[i].remove(val);
                    }
                }
                start++;
            }
        }
        
        for(int i = 0; i < m; i++){
            pw.print(ret[i] + " ");
        }
    }
}
