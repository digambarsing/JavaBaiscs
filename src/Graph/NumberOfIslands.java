package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(grid));


        // using bfs
        System.out.println("using bfs");
        int c=0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int r= grid.length;
        int col=grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]=='1'){
                    bfs(grid,i,j,directions);
                    c++;
                }
            }
        }

        System.out.println(c);

        System.out.println("Number of islands: " + numIslands(grid));
    }

    private static void bfs(char[][] grid, int i, int j, int[][] directions) {
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i,j});
        grid[i][j] = '0';

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                        && grid[newX][newY] == '1') {
                    q.offer(new int[] { newX, newY });
                    grid[newX][newY] = '0';
                }
            }
        }
    }

    private static int numIslands(char[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }

        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}


// it is a connected components
