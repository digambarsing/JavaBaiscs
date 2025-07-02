package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    static class Edge {
        int src;
        int des;
        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] gp = new ArrayList[v];
        createGraph(gp, v);
        boolean result = isBipartite(gp);
        System.out.println(result);
    }

    private static boolean isBipartite(ArrayList<Edge>[] gp) {
        int[] col = new int[gp.length];
        Arrays.fill(col, -1);

        for (int i = 0; i < gp.length; i++) {
            if (col[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (Edge e : gp[curr]) {
                        int neighbor = e.des;

                        if (col[neighbor] == -1) {
                            col[neighbor] = 1 - col[curr];
                            q.add(neighbor);
                        } else if (col[neighbor] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static void createGraph(ArrayList<Edge>[] gp, int v) {
        for (int i = 0; i < v; i++) {
            gp[i] = new ArrayList<>();
        }

        gp[0].add(new Edge(0, 1));
        gp[0].add(new Edge(0, 2));
        gp[1].add(new Edge(1, 0));
        gp[1].add(new Edge(1, 2));
        gp[2].add(new Edge(2, 0));
        gp[2].add(new Edge(2, 1));
        gp[2].add(new Edge(2, 3));
        gp[3].add(new Edge(3, 2));
    }
}
