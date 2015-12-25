import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNext()) {
            solve(sc, pw);

        }
        sc.close();
        pw.flush();
        pw.close();

    }

    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++){
            pairs[i] = new Pair(sc.nextInt(), i);
        }
        
        Arrays.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.first - p2.first;
            }
        });
        
        long ans = 0;
        for(int i = 1; i < n; i++){
            ans += Math.abs(pairs[i].second - pairs[i-1].second);
        }
        pw.println(ans);
    }

}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}