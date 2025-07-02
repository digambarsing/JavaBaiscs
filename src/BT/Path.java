package BT;

import java.util.ArrayList;
import java.util.Arrays;

public class Path {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(8);

        int[] ar = {5, 2, 4, 8};

        if (help(root, ar)) {
            System.out.println("Sequence exists in the tree.");
        } else {
            System.out.println("Sequence does NOT exist in the tree.");
        }

        if (help(root, ar,0)) {
            System.out.println("Sequence existssss in the tree.");
        } else {
            System.out.println("Sequence does NOT exist in the tree.");
        }
    }
    private static boolean help(Node root,int[]ar,int i){
        if (root==null || i>= ar.length || ar[i]!= root.data){
            return false;
        };
        if(root.left==null && root.right==null && i==ar.length-1){
            return true;
        }
        return help(root.left,ar,i+1)|| help(root.right,ar,i+1);
    }

    private static boolean help(Node root, int[] ar) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        path(root, ans, res);

        for (ArrayList<Integer> a : ans) {
            if (isSame(a, ar)) {
                return true;
            }
        }
        return false;
    }

    private static void path(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> res) {
        if (root == null) return;

        res.add(root.data);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(res));
        }

        path(root.left, ans, res);
        path(root.right, ans, res);

        res.remove(res.size() - 1);
    }

    private static boolean isSame(ArrayList<Integer> list, int[] arr) {
        if (list.size() != arr.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if (list.get(i) != arr[i]) return false;
        }
        return true;
    }
}



//import java.util.*;
//
//class TreeNode {
//    int val;
//    TreeNode left, right;
//
//    TreeNode(int item) {
//        val = item;
//        left = right = null;
//    }
//}
//
//public class PathSequenceChecker {
//
//    public static boolean isSequencePresent(TreeNode root, int[] sequence) {
//        return checkPath(root, sequence, 0);
//    }
//
//    private static boolean checkPath(TreeNode node, int[] sequence, int index) {
//        if (node == null || index >= sequence.length || node.val != sequence[index]) {
//            return false;
//        }
//
//        // If it's a leaf node
//        if (node.left == null && node.right == null && index == sequence.length - 1) {
//            return true;
//        }
//
//        // Recur for left and right subtrees
//        return checkPath(node.left, sequence, index + 1) || checkPath(node.right, sequence, index + 1);
//    }
//
//    // Utility: build example tree
//    public static void main(String[] args) {
//        /*
//                 1
//               /   \
//              2     3
//             / \   / \
//            4   5 6   7
//        */
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//
//        int[] sequence = {1, 2, 4};
//
//        if (isSequencePresent(root, sequence)) {
//            System.out.println("Sequence exists in the tree.");
//        } else {
//            System.out.println("Sequence does not exist in the tree.");
//        }
//    }
//}
//
