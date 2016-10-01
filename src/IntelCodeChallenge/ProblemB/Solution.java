
/**
 * Created by eric on 10/1/16.
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
        int[] p = new int[n];
        String[] s = new String[n];
        for(int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++) {
            s[i] = in.nextLine();
        }

        for(int i = 0; i < n; i++){
            String[] tmp = s[i].split("\\s+");
            int cnt = 0;
            for (int j = 0; j < tmp.length; j++){
                cnt += countVowel(tmp[j]);
            }
            if(cnt != p[i]){
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }

    public static int countVowel(String s){
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            if("aeiouy".indexOf(s.charAt(i)) != -1){
                ret++;
            }
        }
        return ret;
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
         *
         * @return  next line of string.
         */
        public String nextLine() {

            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
