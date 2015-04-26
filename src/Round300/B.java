package Round300;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-4-26.
 */
public class B {
    public void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(n > 0){
            int tmp = n;
            ArrayList<Integer> digits = new ArrayList<Integer>();
            while(tmp >0){
                digits.add(0, tmp %10);
                tmp /= 10;
            }
            ArrayList<Integer> achievable = new ArrayList<Integer>();
            for(int num : digits){
                achievable.add(Math.min(num, 1));
            }
            int number = 0;
            for(int num : achievable){
                number = number*10 + num;
            }
            list.add(number);
            n -= number;
        }
        pw.println(list.size());
        for(int num : list){
            pw.print(num + " ");
        }
        pw.println();
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
