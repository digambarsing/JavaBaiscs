package BT;
import java.util.*;

public class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            this.left=right=null;
        }

    }

    // Zigzag Level Order Traversal function
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        boolean rtol=false;
        while (!q.isEmpty()){
            int size=q.size();

            List<Integer>ans=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode c=q.poll();
                if (rtol){
                    ans.add(0, c.val);
                }else{
                    ans.add(c.val);
                }
                if (c.left!=null) q.add(c.left);
                if (c.right!=null) q.add(c.right);
            }
            res.add(new ArrayList<>(ans));
            rtol=!rtol;
        }
        return res;

    }

    // Test case inside main()
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.left.left= new TreeNode(4); root.left.right= new TreeNode(5);
        root.right = new TreeNode(3);root.right.right=  new TreeNode(6);

        Solution sol = new Solution();
        List<List<Integer>> zigzag = sol.zigzagLevelOrder(root);

        // Print result
        for (List<Integer> level : zigzag) {
            System.out.println(level);
        }
    }
}

