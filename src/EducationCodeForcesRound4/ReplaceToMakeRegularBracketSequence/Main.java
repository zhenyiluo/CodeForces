import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while (sc.hasNext()) {
            solve(sc, pw);

        }
        sc.close();
        pw.flush();
        pw.close();

    }
    private static void solve(Scanner sc, PrintWriter pw){
        String s = sc.next();
        if(s.length() % 2 != 0){
            pw.println("Impossible");
            return;
        }
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if("<{[(".indexOf(s.charAt(i)) != -1){
                stack.push(s.charAt(i));
                cnt ++;
            }else{
                if(stack.empty()){
                    pw.println("Impossible");
                    return;
                }
                char tmp = stack.pop();
                if(!check(tmp, s.charAt(i))){
                    ans ++;
                }
                cnt --;
            }
            if(cnt < 0){
                pw.println("Impossible");
                return;
            }
        }

        if(cnt != 0){
            pw.println("Impossible");
            return;
        }

        pw.println(ans);
    }

    private static boolean check(char a, char b){
        if(     (a == '<' && b == '>' )||
                (a == '(' && b == ')')||
                (a == '{' && b == '}')||
                (a == '[' && b == ']')
                ){
            return true;
        }else{
            return false;
        }
    }
}