import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by eric on 2016-01-25.
 */
public class Solution {

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
        HashMap<Integer, Integer> hmAdd = new HashMap<>();
        HashMap<Integer, Integer> hmSub = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(!hmAdd.containsKey(x+y)){
                hmAdd.put(x+y, 1);
            } else{
                hmAdd.put(x+y, hmAdd.get(x+y) +1 );
            }

            if(!hmSub.containsKey(y-x)) {
                hmSub.put(y-x, 1);
            }else {
                hmSub.put(y-x, hmSub.get(y-x) + 1);
            }
        }

        long ret = 0;
        for(int val : hmAdd.values()) {
            if(val >= 2) {
                ret += val * (val-1) / 2;
            }
        }

        for(int val : hmSub.values()) {
            if(val >= 2) {
                ret += val * (val-1) /2;
            }
        }

        out.println(ret);
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
