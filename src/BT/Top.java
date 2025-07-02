package BT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Top {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
            this.left=right=null;
        }
    }
    static class info{
        Node curr;
        int hd;    // it is a horizontal distance
        public info(Node curr,int hd){
            this.curr=curr;
            this.hd=hd;
        }
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);


        topView(root);
    }

    private static void topView(Node root) {
        Queue<info>q=new LinkedList<>();
        q.add(new info(root,0));
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0;
        int max=0;
        q.add(null);

        while (!q.isEmpty()){
            info c=q.poll();

            if (c==null){
                if (q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(c.hd)){
                    map.put(c.hd,c.curr);
                }
                if(c.curr.left!=null){
                    q.add(new info(c.curr.left, c.hd-1));
                    min=Math.min(min, c.hd-1);
                }


                if(c.curr.right!=null){
                    q.add(new info(c.curr.right, c.hd+1));
                    max=Math.max(max, c.hd+1);
                }

            }
        }
        for (int i = min; i <=max ; i++) {
            System.out.print(map.get(i).val+" ");
        }
        System.out.println("\nHorizontal Distances and Nodes:");
        for (var entry : map.entrySet()) {
            System.out.println("HD " + entry.getKey() + " -> Node " + entry.getValue().val);
        }


    }
}
