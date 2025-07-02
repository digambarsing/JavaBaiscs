package ArrayCracking;

import java.util.*;

class Pair implements Comparable<Pair> {
    int houseNumber;
    char color;

    public Pair(int houseNumber, char color) {
        this.houseNumber = houseNumber;
        this.color = color;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.houseNumber, other.houseNumber);
    }
}

public class HouseColor {
    public static List<List<String>> reorganizeNeighborhoods(int[][] houses, char[][] colors) {
        List<Pair> sortedPairs = new ArrayList<>();
        int neighborhoods = houses.length;
        int housesPerNeighborhood = houses[0].length;

        // Step 1: Collect all house-color pairs and sort them
        for (int i = 0; i < neighborhoods; i++) {
            for (int j = 0; j < houses[i].length; j++) {
                sortedPairs.add(new Pair(houses[i][j], colors[i][j]));
            }
        }
        Collections.sort(sortedPairs);

        // Step 2: Distribute houses among neighborhoods while ensuring no duplicates in the same subarray
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < neighborhoods; i++) {
            result.add(new ArrayList<>());
        }

        Map<Integer, Integer> houseAssignment = new HashMap<>(); // Map to track house assignments

        int index = 0;
        for (Pair pair : sortedPairs) {
            while (houseAssignment.containsKey(pair.houseNumber) && houseAssignment.get(pair.houseNumber) == index) {
                index = (index + 1) % neighborhoods; // Move to the next neighborhood if a house number repeats
            }
            result.get(index).add(pair.houseNumber + String.valueOf(pair.color));
            houseAssignment.put(pair.houseNumber, index);
            index = (index + 1) % neighborhoods; // Move to the next neighborhood
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] houses = {{8, 2, 9}, {4, 6, 4}, {4, 5, 1}};
        char[][] colors = {{'r', 'g', 'b'}, {'w', 'c', 'b'}, {'x', 'y', 'b'}};

        List<List<String>> sortedNeighborhoods = reorganizeNeighborhoods(houses, colors);

        // Print the result
        for (List<String> neighborhood : sortedNeighborhoods) {
            System.out.println(neighborhood);
        }
    }
}
