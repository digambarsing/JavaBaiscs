package BT;

import java.util.ArrayList;

public class LVRV {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        Node root=new Node(4);
        root.left=new Node(3);
        root.right=new Node(5);
        root.left.left=new Node(2);
        root.left.right=new Node(1);
        root.left.right.left=new Node(6);
        root.left.right.right=new Node(7);

        leftView(root);





    }

    private static void leftView(Node root) {
        ArrayList<Node> ans=new ArrayList<>();
        dfs(root,0,ans);
        for(Node e:ans){
            System.out.print(e.data+" ");
        }
    }

    private static void dfs(Node root, int i, ArrayList<Node> ans) {
        if (root==null) return;
        if (i==ans.size()) ans.add(root);
        dfs(root.right,i+1,ans);
        dfs(root.left,i+1,ans);
//        dfs(root.right,i+1,ans);
    }
}
