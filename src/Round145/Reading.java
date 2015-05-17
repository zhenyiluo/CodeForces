package Round145;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-16.
 */
public class Reading {
    public static class Pair implements Comparable<Pair>{
        int num;
        int id;
        public Pair(int num, int id){
            this.num = num;
            this.id = id;
        }
        @Override
        public int compareTo(Pair p){
            return p.num - this.num;
        }
    }
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int k = sc.nextInt();
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(sc.nextInt(), i+1);
        }
        Arrays.sort(pairs);
        pw.println(pairs[k-1].num);
        for(int i = 0; i < k; i++){
            pw.print(pairs[i].id + " ");
        }
        pw.println();
    }

    public static void main(String[] args)throws FileNotFoundException{
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        new Reading().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
