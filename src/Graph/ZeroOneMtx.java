package Graph;

import java.util.*;

public class ZeroOneMtx{

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize distances
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[]{i, j}); // All 0s as source
                } else {
                    dist[i][j] = -1; // Unvisited
                }
            }
        }

        // Step 2: Direction vectors (up, down, left, right)
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 3: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && dist[newRow][newCol] == -1) {
                    dist[newRow][newCol] = dist[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        return dist;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);
        System.out.println("Updated Matrix (Distance to nearest 0):");
        printMatrix(result);
    }
}

