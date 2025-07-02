package PQ;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int N = arr.length;
        int K = 2;

        // Function call
        System.out.println(K + " numbers with most occurrences are:");
        topKFrequent(arr, N, K);
    }

    private static void topKFrequent(int[] arr, int n, int k) {
        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        System.out.println("Frequency Map: " + map);

        // Step 2: Use a max heap to sort by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ?
                        Integer.compare(b.getKey(), a.getKey()) : // Larger key first if same frequency
                        Integer.compare(b.getValue(), a.getValue()) // Higher frequency first
        );

        // Add elements to PQ
        for (var e : map.entrySet()) {
            pq.offer(e);
        }

        System.out.println("Priority Queue: " + pq);

        // Step 3: Extract top K elements
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            System.out.print(pq.poll().getKey() + " ");
        }
    }
}
