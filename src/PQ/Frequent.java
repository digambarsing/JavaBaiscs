package PQ;

import java.util.*;

public class Frequent {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
        int N = arr.length;
        int K = 2;

        // Function call
        System.out.println(
                K + " numbers with most occurrences are:");
        topKFrequent(arr, N, K);
    }

    private static void topKFrequent(int[] arr, int n, int k) {

        Map<Integer,Integer>map=new HashMap<>();

        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }

//        List<Map.Entry<Integer,Integer>>list=new ArrayList<>(map.entrySet());
//        Collections.sort(list,
//                new Comparator<Map.Entry<Integer, Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                        if (o1.getValue() == o2.getValue()){
//                            return o2.getKey()- o1.getKey();
//                        }else{
//                            return o2.getValue()- o1.getValue();
//                        }
//                    }
//                });
//
//        System.out.println(list);


        PriorityQueue<Map.Entry<Integer, Integer> > queue
                = new PriorityQueue<>(
                (a, b)
                        -> a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(),
                        a.getKey())
                        : Integer.compare(b.getValue(),
                        a.getValue()));

        // Insert the data from the map
        // to the Priority Queue.
        for (var entry :
                map.entrySet())
            queue.offer(entry);

        for (int i = 0; i < k; i++) {
            System.out.print(queue.poll().getKey()+" ");

        }

    }
}
