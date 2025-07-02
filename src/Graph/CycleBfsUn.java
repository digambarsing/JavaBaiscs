package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleBfsUn {
    static ArrayList<Integer>[] gp;
    public static void main(String[] args) {

        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 4}
        };
        int V = 5;

        createGraph(edges,V);
        System.out.println(isCycle(V, edges) ? "true"
                : "false");
    }

    private static boolean isCycle(int v, int[][] edges) {
        Queue<int[]>q=new LinkedList<>();
        boolean[]vis=new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]){
                if(bfsUtil(v,edges,q,vis,i)) return true;
            }
        }
        return false;
    }

    private static boolean bfsUtil(int v, int[][] edges, Queue<int[]> q, boolean[] vis, int i) {
        q.add(new int[]{i,-1});
        vis[i]=true;
        
        while (!q.isEmpty()){
            int []curr=q.poll();
            int node=curr[0];
            int par=curr[1];
            for(int n:gp[node]){
                if (!vis[n]){
                    q.add(new int[]{n,node});
                    vis[n]=true;
                } else if (par!=n) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void createGraph(int[][] edges , int v) {
        gp=new ArrayList[v];
        for (int i = 0; i < v; i++) {
            gp[i]=new ArrayList<>();
        }
        for(int[]eg:edges){
            int u=eg[0];
            int w=eg[1];
            gp[u].add(w);
            gp[w].add(u);

        }


    }
}
