package ArrayCracking.MinAraRect;

import java.util.*;

class Basic {
    public static int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store points in the map
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int ans = Integer.MAX_VALUE;

        // Check all unique pairs
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];

            for (int j = i + 1; j < points.length; j++) { // Compare all pairs
                int[] p2 = points[j];

                // Check if p1 and p2 are diagonally opposite
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    // Ensure the other two rectangle points exist
                    if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                        int area = Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]);
                        ans = Math.min(ans, area);
                    }
                }
            }
        }

        // If no rectangle found, return 0
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
        };
        System.out.println("Minimum Area: " + minAreaRect(points));
    }
}
