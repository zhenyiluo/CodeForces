package Round7;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-5-19.
 */
public class KalevitchAndChess {
    public static void solve(Scanner sc ,PrintWriter pw){
        char[][] board = new char[8][8];
        for(int i = 0; i < 8; i++){
            board[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for(int i = 0; i <8; i++){
            boolean flag = true;
            for(int j = 0; j < 8 && flag; j++){
                if(board[i][j] == 'W'){
                    flag = false;
                }
            }
            if(flag){
                ans++;
            }
        }

        if(ans == 8){
            pw.println(ans);
            return;
        }

        for(int j = 0; j < 8; j++){
            boolean flag = true;
            for(int i = 0; i < 8 && flag ; i++){
                if(board[i][j] == 'W'){
                    flag = false;
                }
            }
            if(flag){
                ans++;
            }
        }
        pw.println(ans);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        new KalevitchAndChess().solve(sc, pw);
        pw.flush();
        pw.close();
        sc.close();
    }
}
