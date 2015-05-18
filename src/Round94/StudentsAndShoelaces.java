package Round94;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class StudentsAndShoelaces {
    public static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer>[] hs = new HashSet[n];
        for(int i = 0; i < n; i++){
            hs[i] = new HashSet<Integer>();
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            hs[a].add(b);
            hs[b].add(a);
        }

        int ans = 0;
        while(true){
            boolean flag = false;
            ArrayList<Pair> list = new ArrayList<Pair>();
            for(int i = 0; i < n; i++){
                if(hs[i].size() ==1){
                    flag = true;
                    int num = hs[i].iterator().next();
                    list.add(new Pair(num, i));
                }
            }
            if(flag){
                ans++;
                for(Pair p : list){
                    hs[p.first].remove(p.second);
                    hs[p.second].remove(p.first);
                }
            }else{
                break;
            }
        }
        pw.println(ans);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new StudentsAndShoelaces().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
