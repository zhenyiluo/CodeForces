import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.flush();
        out.close();

    }
    private static void solve(InputReader sc, PrintWriter pw){
        int n = sc.nextInt();
        int k = sc.nextInt();
        Point[] points = new Point[n * 2];
        for(int i = 0; i < n; i++){
            points[i * 2] = new Point(sc.nextInt(), 1);
            points[i * 2 + 1] = new Point(sc.nextInt(), -1);
        }
        Arrays.sort(points, (p1, p2) -> {
            if(p1.pos == p2.pos){
                return p2.flag - p1.flag;
            }
            return p1.pos - p2.pos;
        });


        List<Interval> intervals = new ArrayList<>();
        int cnt = 0;
        boolean state = false;
        Interval tmp = null;
        for(int i = 0; i < 2 * n; i ++){
            int pos = points[i].pos;
            int flag = points[i].flag;
            if(flag == 1){
                cnt ++;
                if(cnt >= k && !state){
                    state = true;
                    tmp = new Interval(pos, -1);
                }
            }else{
                cnt --;
                if(cnt < k && state){
                    state = false;
                    tmp.end = pos;
                    intervals.add(tmp);
                }
            }
        }
//
//        if(intervals.size() > 1){
//            List<Interval> tmpIntervals = new ArrayList<>();
//            Interval cur = intervals.get(0);
//            for(int i = 1; i < intervals.size(); i++){
//                Interval next = intervals.get(i);
//                if(next.start == cur.end){
//                    cur.end = next.end;
//                }else{
//                    tmpIntervals.add(cur);
//                    cur = next;
//                }
//            }
//            tmpIntervals.add(cur);
//
//            intervals = tmpIntervals;
//        }


        pw.println(intervals.size());
        for(int i = 0; i < intervals.size(); i++){
            pw.println(intervals.get(i).start + " " + intervals.get(i).end);
        }
    }

    static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

    }

    static class Point{
        int pos;
        int flag;
        public Point(int pos, int flag){
            this.pos = pos;
            this.flag = flag;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}