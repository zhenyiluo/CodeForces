
/**
 * Created by eric on 10/1/16.
 */
import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Solution {
    static long[] sum;
    static class Element implements Comparable<Element>{
        int start;
        int end;
        long total;
        public Element(int start, int end){
            this.start = start;
            this.end = end;
            total = sum[end+1] - sum[start];
        }


        @Override
        public int compareTo(Element o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.flush();
        out.close();
    }

    public static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        sum = new long[n+1];
        sum[0] = 0;
        for(int i = 0; i < n; i++){
            sum[i+1] = sum[i] + in.nextLong();
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(sum[n], 1);

        TreeSet<Element> set = new TreeSet<>();
        set.add(new Element(0, n-1));

        int[] index = new int[n];
        for(int i = 0; i < n; i++){
            index[i] = in.nextInt() -1;
        }
        long[] ret = new long[n];
        for(int i = 0; i < n-1; i++){
            int pos = index[i];
            Element eTmp = set.floor(new Element(pos, pos));
            if(map.get(eTmp.total) ==1){
                map.remove(eTmp.total);
            }else{
                map.put(eTmp.total, map.get(eTmp.total) -1);
            }
            set.remove(eTmp);
            if (eTmp.end == eTmp.start){
                set.remove(eTmp);
            }else if (eTmp.start == pos){
                Element tmp = new Element(pos+1, eTmp.end);
                set.add(tmp);
                if(map.containsKey(tmp.total)){
                    map.put(tmp.total, map.get(tmp.total) +1);
                }else{
                    map.put(tmp.total, 1);
                }
            } else{
                Element tmp1 = new Element(eTmp.start, pos-1);
                Element tmp2 = new Element(pos+1, eTmp.end);
                set.add(tmp1);
                set.add(tmp2);
                if(map.containsKey(tmp1.total)){
                    map.put(tmp1.total, map.get(tmp1.total) +1);
                }else{
                    map.put(tmp1.total, 1);
                }
                if(map.containsKey(tmp2.total)){
                    map.put(tmp2.total, map.get(tmp2.total) +1);
                }else{
                    map.put(tmp2.total, 1);
                }
            }
            ret[i] = map.lastKey();
        }
        for(int i = 0; i < n; i++){
            out.println(ret[i]);
        }
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public static final int BUFFER_SIZE = 32768;

        /**
         * Input stream constructor, using a buffer to optimize IO
         * @param stream    InputStream
         */
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

        /**
         *
         * @return  next string.
         */
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

        /**
         * Get next int
         * @return  next int from input
         */
        public int nextInt() {
            return Integer.parseInt(next());
        }

        /**
         * Get next long
         * @return  next long from input
         */
        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}
