package Graph;

import java.util.ArrayList;

public class CycleDfsDi {
    static ArrayList<Integer>[]gh;
    public static void main(String[] args) {

        int V = 4;
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
//                { 2, 0 }, // This edge creates a cycle (0 → 2 → 0)
                { 2, 3 }
        };
        createGraph(edges,V);

        System.out.println(isCyclic(V, edges) ? "true"
                : "false");
    }

    private static boolean isCyclic(int v, int[][] edges) {
        boolean[]vis=new boolean[v];
        boolean[]st=new boolean[v];

        for (int i = 0; i <v ; i++) {
            if (!vis[i] && dfsutil(vis,st,v,edges,i)) return true;
        }
        return false;
    }

    private static boolean dfsutil(boolean[] vis, boolean[] st, int v, int[][] edges, int i) {
        vis[i]=true;
        st[i]=true;

        for(int e:gh[i]){
            if (!vis[e] && dfsutil(vis,st,v,edges,e)) return true;
            if(vis[e] && st[e]) return true;
        }
        st[i]=false;
        return false;
    }

    private static void createGraph(int[][] edges, int v) {
        gh=new ArrayList[v];
        for (int i = 0; i < v; i++) {
            gh[i]=new ArrayList<>();
        }
        for(int[]edge:edges){
            int u=edge[0];
            int w=edge[1];
            gh[u].add(w);
        }
    }
}
