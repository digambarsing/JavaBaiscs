package Goldman.Medium.MinPathSum;

public class Brute {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(helper(grid));
    }

    private static int helper(int[][] grid) {
        return help(grid, 0, 0);
    }

    private static int help(int[][] grid, int rs, int cs) {
        if (rs == grid.length - 1 && cs == grid[0].length - 1) {
            return grid[rs][cs];
        }

        if (rs >= grid.length || cs >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        int right = help(grid, rs, cs + 1);
        int down = help(grid, rs + 1, cs);

        return grid[rs][cs] + Math.min(right, down);
    }
}
