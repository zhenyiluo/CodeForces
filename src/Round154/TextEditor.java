import java.io.*;
import java.util.*;

public class TextEditor {
    static boolean[][] visited;
    static int[] a;
    static int n;
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("input.txt"));
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i< n; i++){
            a[i] = sc.nextInt();
        }
        
        int startX = sc.nextInt()-1;
        int startY = sc.nextInt()-1;
        int endX = sc.nextInt() -1;
        int endY = sc.nextInt() -1;
        sc.close();
        visited = new boolean[100][100002];
        solve(startX, startY, endX, endY);
        
    }
    
    private static void solve(int startX, int startY, int endX, int endY) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("output.txt");
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startX);
        q.add(startY);
        q.add(0);
        visited[startX][startY] = true;
        while(!q.isEmpty()){
            int tmpX = q.poll();
            int tmpY = q.poll();
            int step = q.poll();
            
            if(tmpX == endX && tmpY == endY){
                pw.println(step);
                pw.flush();
                pw.close();
                return;
            }
            // Up
            if(tmpX > 0){
                int nx = tmpX -1;
                int ny = Math.min(tmpY, a[nx]);
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    q.add(step+1);
                }
            }
            
            // Down
            if(tmpX < n-1){
                int nx = tmpX +1;
                int ny = Math.min(tmpY, a[nx]);
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    q.add(step+1);
                }
            }
            
            // Left
            if(tmpY > 0){
                int ny = tmpY-1;
                int nx = tmpX;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    q.add(step+1);
                }
                
            }
            
            // Right
            if(tmpY < a[tmpX]){
                int ny = tmpY + 1;
                int nx = tmpX;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    q.add(step+1);
                }
                
            }
        }
    }
}