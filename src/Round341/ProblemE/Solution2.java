import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by eric on 2016-01-25.
 */
public class Solution2 {
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
        int[] cnt = new int[10];
        for(int i = 0; i <n ; i++) {
            int t = in.nextInt();
            cnt[t] ++;
        }
        int[][] s = new int[x][x];
        int[][] a = new int[x][x];
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                if(i == j) {
                    s[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < x; i++) {
            for(int j = 1; j <= 9; j++) {
                a[i][(i * 10 + j) % x] += cnt[j];
            }
        }
        while(b > 0) {
            if ((b & 1) != 0) {
                mul(s, a, x);
            }
            mul(a, a, x);
            b >>= 1;
        }
        out.println(s[0][k]);
    }
    static int[][] tmp = new int[100][100];
    private static void mul(int[][] a, int[][] b, int x) {
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++) {
                tmp[i][j] = 0;
                for(int k = 0; k < x; k++) {
                    tmp[i][j] = (int) ((tmp[i][j] + (long) a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                a[i][j] = tmp[i][j];
            }
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
