package BT;

import java.util.Scanner;

public class CreateBT {

    class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
            this.left=right=null;
        }
    }
    public static void main(String[] args) {

        CreateBT tree=new CreateBT();
       Node root= tree.createTree();
       inorder(root);

    }

    private static void inorder(Node root) {
        if (root==null) return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    private Node createTree() {
        Scanner sc=new Scanner(System.in);


        if (sc.hasNext("null")){
            sc.next();
            return null;
        }
        if (sc.hasNextInt()){
            int data= sc.nextInt();
            Node temp=new Node(data);

            temp.left=createTree();
            temp.right=createTree();
            return temp;


        }

        return null;
    }
}
