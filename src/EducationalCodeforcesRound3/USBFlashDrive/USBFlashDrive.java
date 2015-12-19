import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by eric on 2015-12-19.
 */
public class USBFlashDrive {
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
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int i = 0;
        int j = n-1;
        int sum = 0;
        while(sum <m){
            sum += a[j];
            i++;
            j--;
        }
        pw.println(i);
    }

}
