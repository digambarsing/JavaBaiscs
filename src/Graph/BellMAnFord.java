package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellMAnFord {
    static class Node{
        int src;
        int des;
        int weg;
        public Node(int src,int des,int weg){
            this.src=src;
            this.des=des;
            this.weg=weg;
        }
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Node>[] graph = new ArrayList[v];
        createGraph(graph);
        int src=0;

        bellmanFord(graph,src);

    }

    private static void bellmanFord(ArrayList<Node>[] graph, int src) {
        int[]dis=new int[graph.length];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;

        for (int i = 0; i < graph.length-1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Node e=graph[j].get(k);
                    if (dis[e.src]!=Integer.MAX_VALUE && dis[e.src]+e.weg<dis[e.des]){
                        dis[e.des]=dis[e.src]+e.weg;
                    }
                }

            }

        }
        for (int j = 0; j < graph.length; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                Node e=graph[j].get(k);

                if (dis[e.src]!=Integer.MAX_VALUE && dis[e.src]+e.weg<dis[e.des]){
                    System.out.println("negative cycle found!!!");
                    break;
                }

            }

        }

        for(int k:dis){
            System.out.print(k+" ");
        }
    }

    public static void createGraph(ArrayList<Node>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Node(0,1,2));
        graph[0].add(new Node(0,2,4));

        graph[1].add(new Node(1,2,-4));


        graph[2].add(new Node(2,3,2));


        graph[3].add(new Node(3,4,4));

        graph[4].add(new Node(4,1,-1));

    }
}
