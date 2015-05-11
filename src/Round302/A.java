package Round302;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-10.
 */
public class A {
    public void solve(Scanner sc, PrintWriter pw){
        int k = sc.nextInt();
        String q = sc.next();
        ArrayList<String> ans = new ArrayList<String>();
        boolean[] mask = new boolean[26];
        int index = 0;
        while(k > 0){
            if(index >= q.length()){
                pw.println("NO");
                return;
            }
            if(k == 1){
                ans.add(q.substring(index));
            }else{
                mask[q.charAt(index) - 'a'] = true;
                int end = index;
                while(end + 1 < q.length() && mask[q.charAt(end+1) - 'a']){
                    end++;
                }
                ans.add(q.substring(index, end + 1));
                index = end + 1;
            }
            k--;
        }
        pw.println("YES");
        for(int i = 0; i < ans.size(); i++){
            pw.println(ans.get(i));
        }
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
