package BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Zigzag {
    static class Node{
        int val;
        Node l;
        Node r;
        public Node(int val){
            this.val=val;
            this.l=this.r=null;
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


        ArrayList<ArrayList<Node>>ans=new ArrayList<>();
        zigzag(root,ans);

        for(ArrayList<Node>a:ans){
            for(Node c:a){
                System.out.print(c.val+" ");
            }
            System.out.println();
        }
    }

    private static void zigzag(Node root,  ArrayList<ArrayList<Node>> ans) {
        if (root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        boolean ltor=true;

        while (!q.isEmpty()){
            int size=q.size();
            ArrayList<Node> list=new ArrayList<>();


            for (int i = 0; i < size; i++) {
                Node curr=q.poll();

                if (ltor){
                    list.add(curr);
                }else{
                    list.add(0,curr);
                }

                if (curr.l!=null) q.add(curr.l);
                if (curr.r!=null) q.add(curr.r);

            }
            ans.add(list);
            ltor=!ltor;
        }
    }

}
