package Round61;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class PetyaAndJava {
    public static void solve(Scanner sc ,PrintWriter pw){
        String s = sc.next();
        try{
            Byte.valueOf(s);
            pw.println("byte");
        }catch(NumberFormatException e){
            try{
                Short.valueOf(s);
                pw.println("short");
            }catch(NumberFormatException e1){
                try{
                    Integer.valueOf(s);
                    pw.println("int");
                }catch(NumberFormatException e2){
                    try{
                        Long.valueOf(s);
                        pw.println("long");
                    }catch(NumberFormatException e3){
                        pw.println("BigInteger");
                    }
                }
            }
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new PetyaAndJava().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
