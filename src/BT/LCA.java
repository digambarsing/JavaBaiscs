package BT;

import java.util.ArrayList;

public class LCA {
     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4;
        int n2 = 5;

        Node ans = lca(root, n1, n2);
        if (ans != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + ans.data);
        } else {
            System.out.println("LCA does not exist");
        }

        Node ans1=lca2(root,n1,n2);
        System.out.println(ans1.data+" ");
    }

    private static Node lca2(Node root, int n1, int n2) {
        ArrayList<Node> list1=new ArrayList<>();
        ArrayList<Node> list2=new ArrayList<>();

        if (!getpath(root,n1,list1) || !getpath(root,n2,list2)){
            return null;
        }

        int i=0;

        for (;i<list1.size()&& i<list2.size();i++){
            if (!list1.get(i).equals(list2.get(i))) {
                break;
            }
        }
        return list1.get(i-1);
    }

    private static boolean getpath(Node root, int n, ArrayList<Node> list) {
        if (root==null) return false;
        list.add(root);

        if (root.data==n) return true;

        if (root.left!=null && getpath(root.left,n,list)){
            return true;
        }
        if (root.right!=null && getpath(root.right,n,list)){
            return true;
        }

        list.remove(list.size()-1);
        return false;
    }

    private static Node lca(Node root, int n1, int n2) {
        if (root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node left=lca(root.left,n1,n2);
        Node right=lca(root.right,n1,n2);

        if (left==null) return right;
        if (right==null) return left;

        return root;
    }
}
