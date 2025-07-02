package BT;

import java.util.*;


public class Flatten {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        /*
            Example Tree:
                 1
                / \
               2   5
              / \   \
             3   4   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);


        flat(root);

//        ArrayList<TreeNode> list=new ArrayList<>();
//        preorder(root,list);
//        llcreate(list);
//
//
//
//        System.out.print("Flattened Tree: ");
        printFlattened(root);
    }

    private static void flat(TreeNode root) {
       if (root==null) return;
       TreeNode temp=root;

       while (temp!=null){
           TreeNode ans=temp.left;
           if (ans!=null){
               while (ans.right!=null){
                   ans=ans.right;
               }
               ans.right=temp.right;
               temp.right=temp.left;
               temp.left=null;
           }
           temp=temp.right;
       }

    }

    private static void llcreate(ArrayList<TreeNode> list) {
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev=list.get(i-1);
            TreeNode curr=list.get(i);

            prev.left=null;
            prev.right=curr;
        }
    }
    public static void printFlattened(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    private static void preorder(TreeNode root, ArrayList<TreeNode> list) {
       if (root==null) return;

       list.add(root);
       preorder(root.left,list);
       preorder(root.right,list);
    }
}

