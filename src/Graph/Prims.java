package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Edge{
        int src;
        int des;
        int weg;
        public Edge(int src,int des,int weg){
            this.src=src;
            this.des=des;
            this.weg=weg;
        }

    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair other){
            return this.cost- other.cost;
        }
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        prims(graph);

    }

    private static void prims(ArrayList<Edge>[] graph) {
        boolean[]isvis=new boolean[graph.length];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        ArrayList<Pair>list=new ArrayList<>();
        pq.add(new Pair(0,0));
        int finalCost=0;

        while (!pq.isEmpty()){
            Pair curr=pq.poll();

            if (!isvis[curr.v]){
                isvis[curr.v]=true;
                finalCost+= curr.cost;
                list.add(new Pair(curr.v, curr.cost));


                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge p=graph[curr.v].get(i);
                    if (!isvis[p.des]){
                        pq.add(new Pair(p.des,p.weg));

                    }

                }
            }
        }
        System.out.println(finalCost);
        for(Pair e:list){
            System.out.println(e.v+"---> "+e.cost);
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));

        graph[0].add(new Edge(0,3,30));
        graph[1].add(new Edge(1,0,10));

        graph[1].add(new Edge(1,3,40));
        graph[2].add(new Edge(2,0,15));

        graph[2].add(new Edge(2,3,50));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
}
