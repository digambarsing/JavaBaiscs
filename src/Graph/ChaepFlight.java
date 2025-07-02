package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ChaepFlight {
    static class edge{
        int src;
        int des;
        int weg;

        public edge(int src,int des, int weg){
            this.src=src;
            this.des=des;
            this.weg=weg;
        }
    }

    static class info{
        int v;
        int cost;
        int stop;

        public info(int v,int cost,int stop){
            this.v=v;
            this.cost=cost;
            this.stop=stop;
        }
    }
    public static void main(String[] args) {
        int n=4;
        int[][]flights={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int des=3;
        int stop=1;


        int ans= cheapestFlight(n,flights,src,des,stop);
        System.out.println("cheapest price is :"+  ans);
    }

    private static int cheapestFlight(int n, int[][] flights, int src, int des, int stop) {
        ArrayList<edge>[]graph=new ArrayList[n];
        createGraph(graph,flights);

        int[]dist=new int[n];
        for (int i = 0; i < n; i++) {
            if (i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<info>q=new LinkedList<>();
        q.add(new info(0,0,0));

        while (!q.isEmpty()){
            info curr=q.poll();

            if (curr.stop>stop){
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                edge e=graph[curr.v].get(i);
                int u=e.src;
                int v=e.des;
                int w=e.weg;


                if ( curr.cost+w<dist[v]  && curr.stop<=stop){
                    dist[v]= curr.cost+w;
                    q.add(new info(v,dist[v], curr.stop+1 ));
                }

            }


            }

        if (dist[des]==Integer.MAX_VALUE){
            return -1;
        }else {
            return dist[des];
        }
        }

    

    private static void createGraph(ArrayList<edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int []f:flights){
            int src=f[0];
            int des=f[1];
            int weg=f[2];

            edge e=new edge(src,des,weg);
            graph[src].add(e);
        }
    }
}
