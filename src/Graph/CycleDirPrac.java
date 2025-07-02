package Graph;

import java.util.ArrayList;

public class CycleDirPrac {
    static class Edge{
        int src;
        int des;

        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]g=new ArrayList[v];
        create(g);
        boolean ans=dfs(g);
        System.out.println(ans?ans:false);

    }

    private static boolean dfs(ArrayList<Edge>[] g) {
        boolean[]isvis=new boolean[g.length];
        boolean[]st=new boolean[g.length];
        for (int i = 0; i <g.length ; i++) {
            if (!isvis[i] && dfsutil(g,isvis,st,i)) return true;
        }
        return false;
    }

    private static boolean dfsutil(ArrayList<Edge>[] g, boolean[] isvis, boolean[] st, int i) {
        isvis[i]=true;
        st[i]=true;

        for (int j = 0; j < g[i].size(); j++) {
            Edge e=g[i].get(j);

            if (!isvis[e.des] && dfsutil(g,isvis,st,e.des)) return true;
            if (isvis[e.des] && st[e.des]) return true;
        }
        st[i]=false;
        return false;
    }

    private static void create(ArrayList<Edge>[] g) {
        for (int i = 0; i < g.length; i++) {
            g[i]=new ArrayList<>();
        }
        g[0].add(new Edge(0,1));
        g[1].add(new Edge(1,2));
        g[2].add(new Edge(2,0));
        g[2].add(new Edge(2,3));
    }
}
