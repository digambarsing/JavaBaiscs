package Graph;

import java.util.*;

public class NumberOfWays {

   static class Pair{
        int node;
        long time;

        public Pair(int node,long time){
            this.node=node;
            this.time=time;
        }
    }
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        ArrayList<ArrayList<Pair>>graph=new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            graph.add(new ArrayList<>());

        }
        for(int[]road:roads){
            int u=road[0];
            int v=road[1];
            int time=road[2];

            graph.get(u).add(new Pair(v,time));
            graph.get(v).add(new Pair(u,time));
        }




        System.out.println(help(graph,n));

    }

    private static int help(ArrayList<ArrayList<Pair>> graph, int n) {
        int MOD = 1_000_000_007;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));
        long[] minTime = new long[n];
        int[] count = new int[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        minTime[0] = 0;
        count[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long currTime = curr.time;

            if (currTime > minTime[node]) continue;

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                long newTime = currTime + neighbor.time;

                if (newTime < minTime[nextNode]) {
                    minTime[nextNode] = newTime;
                    count[nextNode] = count[node];  
                    pq.add(new Pair(nextNode, newTime));
                }
                else if (newTime == minTime[nextNode]) {
                    count[nextNode] = (count[nextNode] + count[node]) % MOD;
                }
            }
        }

        return count[n - 1];
    }
}
