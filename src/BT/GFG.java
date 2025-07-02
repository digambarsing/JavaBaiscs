package BT;
// Node class representing a node of the binary tree
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class GFG {

    // Returns the maximum path sum in the subtree with the current node as an endpoint.
    // Also updates 'res' with the maximum path sum.
    static int maxPathSumUtil(Node root, int[] res) {
       if (root==null) return 0;

       int l=Math.max(0,maxPathSumUtil(root.left,res));
       int r=Math.max(0,maxPathSumUtil(root.right,res));

       res[0]=Math.max(res[0],l+r+root.data);
       return root.data+Math.max(l,r);
    }

    // Returns the maximum path sum in the binary tree
    static int maxPathSum(Node root) {
        int[] res = {Integer.MIN_VALUE}; // Initialize to very small value
        maxPathSumUtil(root, res);
        return res[0];
    }

    // Driver Code to test the above logic
    public static void main(String[] args) {
        /*
                 10
                /  \
               2    10
              / \     \
             20  1     -25
                        / \
                       3   4
        */

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        System.out.println("Maximum Path Sum is: " + maxPathSum(root));
    }
}

