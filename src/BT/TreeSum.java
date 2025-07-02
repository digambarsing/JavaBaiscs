package BT;

public class TreeSum {
    static class Node{
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
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println(treePathsSum(root, 0));


    }

    private static int treePathsSum(Node root, int val) {
        if (root==null){
            return 0;
        }
        val=val*10+ root.data;
        if (root.left==null && root.right==null){
            return val;
        }
        return treePathsSum(root.left,val)+treePathsSum(root.right,val);
    }
}
