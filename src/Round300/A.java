package Round300;

/**
 * Created by Zhenyi Luo on 15-4-26.
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

    public void solve(Scanner sc, PrintWriter pw){
        String s = sc.next();
        if(s.length() < 10){
            pw.println("NO");
            return;
        }
        if(s.length() == 10 && !s.equals("CODEFORCES")){
            pw.println("NO");
            return;
        }
        if(s.startsWith("CODEFORCES") || s.endsWith("CODEFORCES")){
            pw.println("YES");
            return;
        }
        int len = 1;
        for(int i = len; i <=9; i++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(s.length()-10+i);
            if((s1+s2).equals("CODEFORCES")){
                pw.println("YES");
                return;
            }
        }
        pw.println("NO");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new A().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}