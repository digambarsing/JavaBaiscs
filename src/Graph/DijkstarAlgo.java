package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstarAlgo {
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
        int node;
        int cost;
        public Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair other){
            return this.cost- other.cost;
        }
    }
    public static void main(String[] args) {
        // it is a greedy algo,that is used to find out shortest distance from src to all vertices.
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        dijkstras(graph,0);

    }

    private static void dijkstras(ArrayList<Edge>[] graph, int sr) {
        boolean[]isvis=new boolean[graph.length];
        int[]dis=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i!=sr){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(sr,0));
        while (!pq.isEmpty()){
            Pair curr=pq.poll();
            if (!isvis[curr.node]){
                isvis[curr.node]=true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.des;
                    int w= e.weg;

                    if (dis[u]+w<dis[v]){
                        dis[v]=dis[u]+w;
                        pq.add(new Pair(v,dis[v]));
                    }

                }
            }
        }
        for(int d:dis){
            System.out.print(d+" ");
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
}
