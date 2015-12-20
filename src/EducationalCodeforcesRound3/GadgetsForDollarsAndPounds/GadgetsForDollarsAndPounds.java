import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by eric on 2015-12-19.
 */
public class GadgetsForDollarsAndPounds {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        solve(sc, pw);
        sc.close();
        pw.flush();
        pw.close();
    }

    private static void solve(Scanner sc, PrintWriter pw) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long s = sc.nextLong();
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }
        long[] b = new long[n];
        for(int i = 0; i < n; i++){
            b[i] = sc.nextLong();
        }
        ArrayList<Long> dollars = new ArrayList<>();
        ArrayList<Long> pounds = new ArrayList<>();
        ArrayList<Pair> dollarsPair = new ArrayList<>();
        ArrayList<Pair> poundsPair = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int type = sc.nextInt();
            long data = sc.nextLong();
            if(type == 1){
                dollars.add(data);
                dollarsPair.add(new Pair(data, i));
            }else{
                pounds.add(data);
                poundsPair.add(new Pair(data, i));
            }
        }

        Collections.sort(dollars);
        Collections.sort(pounds);

        Collections.sort(dollarsPair, (o1, o2) -> {
            if(o1.first == o2.first){
                return o1.second - o2.second;
            }
            return (int)(o1.first - o2.first);
        });
        
        Collections.sort(poundsPair, (o1, o2) -> {
            if(o1.first == o2.first){
                return o1.second - o2.second;
            }
            return (int)(o1.first - o2.first);
        });
        
        int sizeDollars = dollars.size();
        int sizePounds = pounds.size();
        long[] preSumDollars = new long[sizeDollars+1];
        long[] preSumPounds = new long[sizePounds+1];
        for(int i = 0; i < sizeDollars; i++){
            preSumDollars[i+1] = preSumDollars[i] + dollars.get(i);
        }
        for(int i = 0; i < sizePounds; i++){
            preSumPounds[i+1] = preSumPounds[i] + pounds.get(i);
        }



        long minA = findMinInFirstNElements(a, n-1);
        long minB = findMinInFirstNElements(b, n-1);
        if(check(s, k, minA, minB, preSumDollars, preSumPounds)== -1){
            pw.println(-1);
        }else{
            int left = 0;
            int right = n-1;
            int x = -1;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                minA = findMinInFirstNElements(a, mid);
                minB = findMinInFirstNElements(b, mid);
                int y = check(s, k, minA, minB, preSumDollars, preSumPounds);
                if(y != -1){
                    x = y;
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
            }
            minA = findMinInFirstNElements(a, left);
            minB = findMinInFirstNElements(b, left);
            int minPosA = -1;
            int minPosB = -1;
            for(int i = 0; i < n; i++){
                if(Long.compare(a[i],minA) == 0){
                    minPosA = i;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
                if(Long.compare(b[i],minB) == 0){
                    minPosB = i;
                    break;
                }
            }
            pw.println(left + 1);
            int index1 = 0;
            int index2 = 0;
            for(int i = 1; i <= k; i++){
                if (i <= x){
                    pw.println(dollarsPair.get(index1++).second+1 + " " + (minPosA+1));
                }else{
                    pw.println(poundsPair.get(index2++).second+1 + " " + (minPosB+1));
                }
            }
        }
    }

    private static int check(long s, int k, long minA, long minB, long[] preSumDollars, long[] preSumPounds) {
        for(int i = 0; i <= k; i++){
            int j = k - i;
            if(i+1 > preSumDollars.length || j+1 > preSumPounds.length){
                continue;
            }
            if(preSumDollars[i] * minA + preSumPounds[j] * minB <= s){
                return i;
            }
        }
        return -1;
    }

    private static long findMinInFirstNElements(long[] a, long n){
        long ret = Long.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            ret = Math.min(ret, a[i]);
        }
        return ret;
    }
}

class Pair{
    long first;
    int second;
    public Pair(long first, int second){
        this.first = first;
        this.second = second;
    }
}
