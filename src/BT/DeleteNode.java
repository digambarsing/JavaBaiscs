package BT;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
    static  class Node{
        int data;
        Node left;
        Node right;

        public Node(int val){
            this.data=val;
            this.left=this.right=null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        System.out.print("Original tree (in-order): ");
        inorder(root);
        System.out.println();

        int valToDel = 3;
        root = deleteNode(root, valToDel);

        System.out.print("Tree after deleting " + valToDel + " (in-order): ");
        inorder(root);
        System.out.println();

    }

    private static Node deleteNode(Node root, int valToDel) {
        if (root==null) return null;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        Node target=null;

        while (!q.isEmpty()){
            Node curr=q.poll();

            if (curr.data==valToDel){
                target=curr;
                break;
            }

            if (curr.left!=null) q.add(curr.left);
            if (curr.right!=null) q.add(curr.right);
        }

        if (target==null) return root;

        // find last node

        Node lastnode=null;
        Node lastParent=null;

        Queue<Node> queue=new LinkedList<>();
        Queue<Node> parqueue=new LinkedList<>();

        queue.add(root);
        parqueue.add(null);

        while (!queue.isEmpty()){
            Node curr=queue.poll();
            Node parent=parqueue.poll();
            lastnode=curr;
            lastParent=parent;

            if (curr.left!=null){
                queue.add(curr.left);
                parqueue.add(curr);
            }

            if (curr.right!=null){
                queue.add(curr.right);
                parqueue.add(curr);
            }
        }
        target.data=lastnode.data;

        if (lastParent!=null){
            if (lastParent.left==lastnode) {
                lastParent.left=null;
            }else{
                lastParent.right=null;
            }
        }else {
            return null;
        }
        return root;
    }

    private static void inorder(Node root) {
        if (root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
