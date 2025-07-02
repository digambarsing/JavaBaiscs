package Graph;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CyclePrac {
    static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    static class Pair{
        int node;
        int par;

        public Pair(int node,int par){
            this.node=node;
            this.par=par;
        }
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]gp=new ArrayList[v];
        createGRaph(gp);
        boolean ans=detect(gp);
        System.out.println(ans?ans:-1);

    }

    private static boolean detect(ArrayList<Edge>[] gp) {

        boolean[]isvis=new boolean[gp.length];
        Queue<Pair>q=new LinkedList<>();

        for (int i = 0; i < gp.length; i++) {
            if(!isvis[i]){
                if(utill(gp,isvis,q,i)) return true;
            }
        }
        return false;
    }

    private static boolean utill(ArrayList<Edge>[] gp, boolean[] isvis, Queue<Pair> q, int i) {
        q.add(new Pair(i,-1));
        isvis[i]=true;

        while (!q.isEmpty()){
            Pair p=q.poll();
            int n=p.node;
            int pa= p.par;

            for (int j = 0; j < gp[n].size(); j++) {
                Edge e=gp[n].get(j);

                if (!isvis[e.des]){
                    isvis[e.des]=true;
                    q.add(new Pair(e.des,n));
                } else if (e.des!=pa) {
                    return true;

                }
            }
        }
        return false;
    }

    private static void createGRaph(ArrayList<Edge>[] gp) {
        for (int i = 0; i < gp.length; i++) {
            gp[i]=new ArrayList<>();
        }
        gp[0].add(new Edge(0,1));
//        gp[0].add(new Edge(0,2));

        gp[1].add(new Edge(1,0));
        gp[1].add(new Edge(1,2));

//        gp[2].add(new Edge(2,0));
        gp[2].add(new Edge(2,1));
        gp[2].add(new Edge(2,3));

        gp[3].add(new Edge(3,2));
    }
}
