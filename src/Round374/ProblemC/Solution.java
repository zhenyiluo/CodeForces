
/**
 * Created by eric on 9/30/16.
 */
import java.io.*;
import java.util.*;

class AnotherNode{
    int n;
    int w;
    public AnotherNode(int n, int w){
        this.n = n;
        this.w = w;
    }
}

class Element{
    int n;
    int backNode;
    public Element(int n, int backNode){
        this.n = n;
        this.backNode = backNode;
    }
}
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
        int m = in.nextInt();
        int T = in.nextInt();

        ArrayList<AnotherNode>[] graph = new ArrayList[n+1];
        HashMap<Integer, Element>[] dp = new HashMap[n+1];
        dp[1] = new HashMap<>();
        dp[1].put(0, new Element(0, 0));


        for(int i = 0; i < m; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            if(graph[u] == null){
                graph[u] = new ArrayList<>();
            }
            graph[u].add(new AnotherNode(v, w));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int node = queue.poll();

            ArrayList<AnotherNode> neighbors = graph[node];
            if(neighbors == null) {
                break;
            }
            for(AnotherNode neighbor: neighbors){
                queue.add(neighbor.n);
                HashMap<Integer, Element> mine = dp[node];
                Set<Integer> set = mine.keySet();
                for(int oriCost: set){
                    if(oriCost + neighbor.w <= T){
                        if(dp[neighbor.n] == null){
                            dp[neighbor.n] = new HashMap<>();
                        }
                        Element el = dp[neighbor.n].get(oriCost+ neighbor.w);
                        if(el == null || el.n < mine.get(oriCost).n + 1){
                            dp[neighbor.n].put(oriCost + neighbor.w, new Element(mine.get(oriCost).n + 1, node));
                        }
                    }
                }
            }
        }

        int result = 0;
        HashMap<Integer, Element> lastNode = dp[n];
        Set<Integer> keys = lastNode.keySet();
        int totalWeight = 0;
        for(int key: keys) {
            if(result < lastNode.get(key).n){
                result = lastNode.get(key).n;
                totalWeight = key;
            }
            result = Math.max(result, lastNode.get(key).n);
        }

        out.println(result+1);

        ArrayList<Integer> list = new ArrayList<>();
        int cur = n;
        while(true){
            list.add(0, cur);
            if(cur == 1) {
                break;
            }
            int backNode = dp[cur].get(totalWeight).backNode;
            ArrayList<AnotherNode> list1 = graph[backNode];
            for(AnotherNode anotherNode: list1) {
                if(anotherNode.n == cur) {
                    totalWeight -= anotherNode.w;
                }
            }
            cur = backNode;
        }

        for(int i = 0; i < list.size(); i++) {
            out.print(list.get(i) + " ");
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
