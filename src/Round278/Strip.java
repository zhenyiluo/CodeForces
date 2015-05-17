package Round278;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-16.
 */
public class Strip {

    public static final int INF = (int)(1e9+10);

    public static class SegmentTree{
        public SegmentTree left, right;
        public int start;
        public int end;
        public int max;

        public SegmentTree(int start, int end){
            this.start = start;
            this.end = end;
            max = -INF;
            if(start != end){
                int mid = (start + end) >> 1;
                left = new SegmentTree(start, mid);
                right = new SegmentTree(mid + 1, end);
            }
        }

        public void update(int p, int v){
            if(start == p && end == p){
                this.max = v;
                return;
            }
            int mid = (start + end) >> 1;
            if(mid >= p){
                left.update(p, v);
            }else{
                right.update(p, v);
            }
            this.max = Math.max(left.max, right.max);
        }

        public int query(int l, int r){
            if(start == l && end == r){
                return max;
            }
            int mid = (start + end) >> 1;
            if(mid >= r){
                return left.query(l, r);
            }else if(mid < l){
                return right.query(l, r);
            }else{
                return Math.max(left.query(l, mid), right.query(mid + 1, r));
            }
        }
    }

    public static void solve(PrintWriter pw, Scanner sc){
        int N = sc.nextInt();
        int S = sc.nextInt();
        int L = sc.nextInt();
        SegmentTree min = new SegmentTree(0, N-1);
        SegmentTree max = new SegmentTree(0, N-1);
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            min.update(i, -num);
            max.update(i, num);
        }
        SegmentTree dpTree = new SegmentTree(0, N);
        dpTree.update(0, 0);
        for(int i = 0; i < N; i ++){
            int left = 0;
            int right = i;
            while(left < right){
                int mid = (left + right) >> 1;
                int a = -min.query(mid, i);
                int b = max.query(mid, i);
                if(b - a > S){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            int tmp = INF;
            int first = left;
            int last = i - L + 1;
            if (first <= last) tmp = -dpTree.query(first, last)+1;
            dpTree.update(i+1, -tmp);
        }
        int ans = -dpTree.query(N, N);
        pw.println(ans > N ? -1 : ans);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new Strip().solve(pw, sc);
        pw.flush();
        pw.close();
        sc.close();
    }
}
