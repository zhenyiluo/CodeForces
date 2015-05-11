package Round302;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-10.
 */
public class B {
    public void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean count1Bigger = true;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                if((i + j) % 2 == 0){
                    count1 ++;
                }else{
                    count2 ++;
                }
            }
        }
        int max = Math.max(count1, count2);
        if(count2 > count1){
            count1Bigger = false;
        }
        if(max < k){
            pw.println("NO");
            return;
        }

        char[][] ans = getBoard(n, count1Bigger, k);

        printBoard(pw, ans, n);
    }

    private void printBoard(PrintWriter pw, char[][] ans, int n) {
        pw.println("YES");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                pw.print(ans[i][j]);
            }
            pw.println();
        }
    }

    private char[][] getBoard(int n, boolean count1Bigger, int k) {
        char[][] ans = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(ans[i], 'S');
        }

        for(int i = 0; i < n && k > 0; i++){
            for(int j = 0; j < n && k > 0; j++){
                if(count1Bigger){
                    if((i+j) % 2 == 0){
                        ans[i][j] = 'L';
                        k--;
                    }
                }else{
                    if((i+j) % 2 != 0){
                        ans[i][j] = 'L';
                        k--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new B().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
