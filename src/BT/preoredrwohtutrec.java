package BT;

import java.util.ArrayList;
import java.util.Stack;

public class preoredrwohtutrec extends inorderWithoutrec {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> res = preorder(root);
        System.out.println(res);
    }

    private static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();


        if (root == null) {
            return new ArrayList<>();
        }
        s.push(root);
        while (!s.isEmpty()) {
            Node t = s.pop();

            ans.add(t.data);

            if (t.right != null) {
                s.push(t.right);
            }
            if (t.left != null) {
                s.push(t.left);
            }
        }

        return ans;


    }

}