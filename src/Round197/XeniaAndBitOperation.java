package Round197;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-17.
 */
public class XeniaAndBitOperation {
    public static int[] a;
    public static class BitTree{
        public BitTree left, right;
        int start;
        int end;
        int val;
        int depth;
        public BitTree(int start, int end){
            this.start = start;
            this.end = end;
            val = a[start];
            depth = 0;
            if(start != end){
                int mid = (start + end) >> 1;
                left = new BitTree(start, mid);
                right = new BitTree(mid+1, end);
                depth = Math.max(left.depth, right.depth) + 1;
                if(depth % 2 == 0){
                    val = left.val ^ right.val;
                }else{
                    val = left.val | right.val;
                }
            }
        }

        public void update(int pos, int val){
            if(this.start == pos && this.end == pos){
                this.val = val;
            }else{
                int mid = (this.start + this.end) >> 1;
                if(mid >= pos){
                    left.update(pos, val);
                }else{
                    right.update(pos, val);
                }
                if(depth % 2 == 0){
                    this.val = left.val ^ right.val;
                }else{
                    this.val = left.val | right.val;
                }
            }
        }
    }
    public static void solve(Scanner sc ,PrintWriter pw){
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[1 << n];
        for(int i = 0; i < (1 << n); i++){
            a[i] = sc.nextInt();
        }
        BitTree tree = new BitTree(0, (1 << n)-1);
        for(int i = 0; i < m; i++){
            int p = sc.nextInt()-1;
            int b = sc.nextInt();
            tree.update(p, b);
            pw.println(tree.val);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new XeniaAndBitOperation().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
