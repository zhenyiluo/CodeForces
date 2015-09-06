import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class PetyaAndHisFriends {
    static int[] primes;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        primes = new int[50];
        initFirstNPrimes(primes, 50);
        while(sc.hasNext()){
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();
    }
    
    private static void initFirstNPrimes(int[] primes, int n){
        int index = 1;
        primes[0] = 2;
        int num = 3;
        while(index < n){
            int k = 0;
            while(primes[k] * primes[k] <= num){
                if(num % primes[k] == 0){
                    k=1;
                    num +=2;
                }else{
                    k++;
                }
            }
            primes[index++] = num;
            num += 2;
        }
    }
    
    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        if(n == 2){
            pw.println(-1);
            return;
        }else{
            BigInteger big = new BigInteger("1");
            for(int i = 0; i < n; i ++){
                BigInteger b = BigInteger.valueOf(primes[i]);
                big = big.multiply(b);
            }
            for(int i = 0; i < n; i++){
                BigInteger tmp = BigInteger.valueOf(primes[i]);
                pw.println(big.divide(tmp));
            }
        }
    }
}
