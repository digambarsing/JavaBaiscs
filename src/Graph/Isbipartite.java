package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Isbipartite {

  static   class Edge{
        int src;
        int des;

        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[]bigraph=new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            bigraph[i]=new ArrayList<>();

        }


        bigraph[0].add(new Edge(0,1));
        bigraph[0].add(new Edge(0,4));

        bigraph[1].add(new Edge(1,0));
        bigraph[1].add(new Edge(1,2));

        bigraph[2].add(new Edge(2,1));
//        bigraph[2].add(new Edge(2,3));

        bigraph[3].add(new Edge(3,4));
//        bigraph[3].add(new Edge(3,2));

        bigraph[4].add(new Edge(4,3));
        bigraph[4].add(new Edge(4,0));


        if(isBipartite(bigraph)){
            System.out.println("yes it is bipartite");
        }else{
            System.out.println("no it is not bipartite");

        }

    }

    private static boolean isBipartite(ArrayList<Edge>[] bigraph) {

      int[]col=new int[bigraph.length];

        Arrays.fill(col,-1);

        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i < bigraph.length; i++) {
            if (col[i]==-1){
                col[i]=0;
                q.add(i);

                while (!q.isEmpty()){
                    int curr=q.poll();
                    for(Edge e:bigraph[curr]){
                        if (col[e.des]==-1){
                            col[e.des]=col[curr]==0?1:0;
                            q.add(e.des);
                        } else if (col[e.des]==col[curr]) {
                            return false;
                        }

                    }
                }
            }

        }
        return true;
    }
}
