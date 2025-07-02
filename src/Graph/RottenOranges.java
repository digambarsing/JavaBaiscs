package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] basket = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int rows = basket.length;
        int cols = basket[0].length;
        int[][] drs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int freshFruit = 0;
        int minutes = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (basket[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (basket[i][j] == 1) {
                    freshFruit++;
                }
            }
        }

        while (!q.isEmpty() && freshFruit > 0) {
            int size = q.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dr : drs) {
                    int r = x + dr[0];
                    int c = y + dr[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && basket[r][c] == 1) {
                        basket[r][c] = 2;
                        freshFruit--;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }

        if (freshFruit > 0) {
            System.out.println("Result: -1 (Not all oranges can rot)");
        } else {
            System.out.println("Result: " + minutes + " minute(s)");
        }
    }
}
