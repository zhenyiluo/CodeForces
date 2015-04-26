package Round300;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-4-26.
 */
public class D {
    public void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        char[][] vector = new char[2*n-1][2*n-1];
        for(int i = 0; i < 2 * n -1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                vector[i][j] = '.';
            }
        }
        vector[n-1][n-1] = 'o';
        for(int i = 0; i < n; i++){
            String s= sc.next();
            board[i] = s.toCharArray();
        }
        ArrayList<Pair> list = new ArrayList<Pair>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'o'){
                    list.add(new Pair(i, j));
                }
            }
        }
        for(int i = 0; i < 2 * n -1; i++){
            for(int  j = 0;  j < 2 * n -1; j++){
                int dx = i - (n-1);
                int dy = j - (n-1);
                if(dx == 0 && dy == 0){
                    continue;
                }
                boolean flag = true;
                    for(Pair pair: list){
                        if(!isOutOfBoundary(pair.x + dx, pair.y + dy, n)){
                            char tmp = board[pair.x + dx][pair.y + dy];
                            if(tmp == 'o'){
                                continue;
                            }
                            if(tmp != 'x'){
                                flag = false;
                            }
                        }
                    }
                if(flag){
                    vector[i][j] = 'x';
                }
            }
        }
        char[][] newBoard = generateBoard(list, vector, n);
        boolean flag = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 'o' && board[i][j] != newBoard[i][j]){
                    flag = false;
                }
            }
        }
        if(!flag){
            pw.println("NO");
            return;
        }
        pw.println("YES");
        for(int i = 0; i < 2 * n -1; i++){
            for(int j = 0; j < 2 * n-1 ; j++){
                pw.print(vector[i][j]);
            }
            pw.println();
        }
    }
    public char[][] generateBoard(ArrayList<Pair> list, char[][] vector, int n){
        char[][] newBoard = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newBoard[i][j] = '.';
            }
        }
        for(int i = 0; i < 2 * n -1 ; i++){
            for(int j = 0; j < 2* n -1; j++){
                if(vector[i][j] == 'x'){
                    int dx = i - (n-1);
                    int dy = j - (n-1);
                    for(Pair pair : list){
                        if(!isOutOfBoundary(pair.x + dx, pair.y + dy, n)){
                            newBoard[pair.x+dx][pair.y+dy] = 'x';
                        }
                    }
                }
            }
        }
        return newBoard;
    }
    public boolean isOutOfBoundary(int x, int y, int n){
        if(x < 0 || y < 0 || x >= n || y >= n){
            return true;
        }
        return false;
    }

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new D().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
