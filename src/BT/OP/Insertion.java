package BT.OP;

import java.util.LinkedList;
import java.util.Queue;

public class Insertion {
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
        Node root = new Node(2);
        root.l = new Node(3);
        root.r = new Node(4);
        root.l.l = new Node(5);

        System.out.print("Inorder traversal before insertion: ");
        inorder(root);
        System.out.println();

        int key = 6;
        root = insert(root, key);

        System.out.print("Inorder traversal after insertion: ");
        inorder(root);
        System.out.println();

    }

    private static Node insert(Node root, int key) {
        if (root==null) return new Node(key);
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node curr=q.poll();

            if (curr.l==null){
                curr.l=new Node(key);
                break;
            }else{
                q.add(curr.l);
            }
            if (curr.r==null){
                curr.r=new Node(key);
                break;
            }else{
                q.add(curr.r);
            }
        }
        return root;
    }

    private static void inorder(Node root) {
        if (root==null) return;
        inorder(root.l);
        System.out.print(root.val+" ");
        inorder(root.r);
    }
}
