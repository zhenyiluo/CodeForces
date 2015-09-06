import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class RentingBikes {
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
        int a = sc.nextInt();
        int[] b = new int[n];
        int[] p = new int[m];
        for(int i = 0; i < n; i ++){
            b[i] = sc.nextInt();
        }
        
        for(int i = 0; i < m; i++){
            p[i] = sc.nextInt();
        }
        
        Arrays.sort(b);
        Arrays.sort(p);
        
        int k = Math.min(n, m);
        int left = 1;
        int right = k;
        int target = 0;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(check(mid, b, p) <= a){
                target = mid;
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        if(target == 0){
            pw.println("0 0");
        }else{
            pw.print(target +  " " );
            long sum = 0;
            for(int i = 0; i < target; i++){
                sum += p[i];
            }
            pw.println(Math.max(0, sum - a));
        }
    }
    
    private static long check(int k, int[] b, int[] p){
        int start = b.length - k;
        long sum = 0;
        for(int i = 0; i < k; i++){
            sum += Math.max(0, p[i] - b[start + i]);
        }
        
        return sum;
    }
}
