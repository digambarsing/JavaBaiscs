package Graph;

import java.util.*;

public class MinStep {

    static class Cell {
        int x, y, dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean isValid(int x, int y, int N) {
        return (x >= 0 && y >= 0 && x < N && y < N);
    }

//    public static int minSteps(int N, int startX, int startY, int targetX, int targetY) {
//        boolean[][] visited = new boolean[N][N];
//        Queue<Cell> q = new LinkedList<>();
//
//        q.add(new Cell(startX, startY, 0));
//        visited[startX][startY] = true;
//
//        while (!q.isEmpty()) {
//            Cell curr = q.poll();
//
//            if (curr.x == targetX && curr.y == targetY) {
//                return curr.dist;
//            }
//
//            for (int i = 0; i < 8; i++) {
//                int newX = curr.x + dx[i];
//                int newY = curr.y + dy[i];
//
//                if (isValid(newX, newY, N) && !visited[newX][newY]) {
//                    visited[newX][newY] = true;
//                    q.add(new Cell(newX, newY, curr.dist + 1));
//                }
//            }
//        }
//
//        return -1; // If not reachable
//    }

    public static void main(String[] args) {
        int N = 8;
        int startX = 3, startY = 4;
        int targetX = 2, targetY = 1;

        int result = minSteps(N, startX, startY, targetX, targetY);
        System.out.println("Minimum steps required: " + result);
    }

    private static int minSteps(int n, int startX, int startY, int targetX, int targetY) {
        Queue<Cell> q=new LinkedList<>();
        boolean[][]isvisit=new boolean[n][n];

        q.add(new Cell(startX,startY,0));
        isvisit[startX][startY]=true;
        while (!q.isEmpty()){
            Cell curr=q.poll();
            if (curr.x == targetX && curr.y == targetY) {
                return curr.dist;
            }

            int x= curr.x;
            int y= curr.y;

            for (int i = 0; i < 8; i++) {
                int newX=x+dx[i];
                int newY=y+dy[i];
                // always check first

                if ((newX >= 0 && newY >= 0 && newX < n && newY < n) && !isvisit[newX][newY] ){
                    q.add(new Cell(newX,newY, curr.dist+1));
                    isvisit[newX][newY]=true;
                }
            }
        }
        return -1;
    }
}


