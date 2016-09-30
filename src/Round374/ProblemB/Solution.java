
/**
 * Created by eric on 9/30/16.
 */

import java.io.*;
import java.util.StringTokenizer;

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
        int k = in.nextInt();

        int[] arr = new int[101];

        for(int i = 0; i < n; i++){
            String s = in.next();
            arr[s.length()]++;
        }

        int target = in.next().length();

        int baseCount = 0;
        int minCount = 1;
        int maxCount = arr[target];

        for(int i = 0; i < target; i++){
            baseCount += arr[i];
        }

        int minTotal = baseCount + minCount;
        int maxTotal = baseCount + maxCount;
        int minTime = (minTotal-1) / k * 5 + minTotal;
        int maxTime = (maxTotal-1) / k * 5 + maxTotal;

        out.println(minTime + " " + maxTime);
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
