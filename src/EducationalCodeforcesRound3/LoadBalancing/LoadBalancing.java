import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by eric on 2015-12-19.
 */
public class LoadBalancing {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        solve(sc, pw);
        sc.close();
        pw.flush();
        pw.close();
    }

    private static void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int sum = 0;
        for(int num : a){
            sum += num;
        }
        if(sum % n == 0){
            int dif = 0;
            int avg = sum / n;
            for(int num : a){
                dif += Math.abs(num - avg);
            }
            pw.println(dif / 2);
        }else{
            int dif = 0;
            int x = sum / n;
            int i = 1;
            for(; i <n; i++){
                if(x * i + (x+1) *(n-i) == sum){
                    break;
                }
            }
            Arrays.sort(a);
            int[] b = new int[n];
            for(int j = 0; j < n; j++){
                if(j < i){
                    b[j] = x;
                }else{
                    b[j] = x+1;
                }
            }
            for(int j = 0; j < n; j++){
                dif += Math.abs(a[j] - b[j]);
            }
            pw.println(dif / 2);
        }
    }
}
