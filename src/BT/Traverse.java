package BT;

import java.util.LinkedList;
import java.util.Queue;

public class Traverse {
    static class Node{
        int data;
        Node l;
        Node r;

        public Node(int data){
            this.data=data;
            this.l=null;
            this.r= null;

        }

    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.l=new Node(2);
        root.r=new Node(3);
        root.l.l=new Node(4);
        root.l.r=new Node(5);
        root.r.r=new Node(6);
        root.r.l=new Node(7);


        level(root);

    }

    private static void level(Node root) {
        if (root==null) return;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node curr=q.poll();
            if (curr==null){
                System.out.println();
                if (q.isEmpty())break;
                else q.add(null);

            }else{
                System.out.print(curr.data+" ");
                if (curr.l!=null){
                    q.add(curr.l);
                }
                if (curr.r!=null){
                    q.add(curr.r);
                }
            }
        }
    }
}
