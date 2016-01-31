// SLow, timeout for large test case
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by eric on 2016-01-25.
 */
public class Solution {
    public static final int MOD = (int) (1e9 + 7);
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
        int b = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long[][][] dp = new long[2][x][10];
        int[] digit = new int[10];
        for(int i = 0; i < n; i++) {
            int next = in.nextInt();
            digit[next] ++;
        }
        int[] prevMod = new int[10];
        for(int j = 0; j < 10; j++){
            if(digit[j] == 0) {
                continue;
            }
            prevMod[j] = j % x;
            dp[0][prevMod[j]][j] = (dp[0][prevMod[j]][j] + digit[j]) % MOD;
        }
        for(int i = 1; i < b; i++) {

            for(int j = 0; j < 10; j++) {
                if(digit[j] == 0) {
                    continue;
                }
                int tmp = (prevMod[j] * 10) % x;
                for(int m = 0; m < 10; m++) {
                    if(digit[m] == 0) {
                        continue;
                    }
                    int val = (prevMod[m] + tmp) % x;
                    dp[1][val][j] = (dp[1][val][j] + (dp[0][prevMod[m]][m] * digit[j]) )% MOD;
                }

            }
            dp[0] = dp[1];
            dp[1] = new long[x][10];
            for(int ii = 0; ii < 10; ii++) {
                prevMod[ii] = (prevMod[ii] * 10) % x;
            }

        }
        long ret = 0;
        for(int i = 0; i < 10; i++) {
            ret += dp[0][k][i];
        }
        ret = ret % MOD;
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
