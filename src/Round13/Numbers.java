package Round13;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class Numbers {
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 2; i < n; i++){
            int num = n;
            while(num != 0){
                sum += num % i;
                num /= i;
            }
        }
        int divisor = gcd(sum, n-2);
        pw.println(sum/divisor + "/" + (n-2)/divisor);
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new Numbers().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
