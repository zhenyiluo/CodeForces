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
        int p = in.nextInt();
        double[] prob = new double[n];
        for(int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            prob[i] = 1.0 - 1.0 * (r/p - (l-1) / p) / (r-l + 1);
        }
        double ret = 1 - prob[0] * prob[n-1];
        for(int i = 0; i < n-1; i++) {
            ret += 1 - prob[i]*prob[i+1];
        }

        out.println(ret * 2000);
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
