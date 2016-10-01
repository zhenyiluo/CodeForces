
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
        int format = in.nextInt();
        String time = in.next();
        String[] times = time.split(":");
        int hour = Integer.valueOf(times[0]);
        int min = Integer.valueOf(times[1]);
        if(format == 24){
            if(hour > 23){
                hour %= 10;
            }
        }else{
            if(hour == 0){
                hour = 1;
            }else if (hour > 12){
                if(hour % 10 != 0){
                    hour %= 10;
                }else{
                    hour = 10;
                }
            }
        }

        if (min > 59) {
            min %= 10;
        }

        String hh = String.valueOf(hour);
        String mm = String.valueOf(min);
        if(hour < 10){
            hh = "0" + hh;
        }

        if(min < 10){
            mm = "0" + mm;
        }

        out.println(hh + ":" + mm);
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
