package BT;

import java.util.*;

public class inorderWithoutrec extends DeleteNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> res = inOrder(root);
        System.out.println(res);
    }

    private static ArrayList<Integer> inOrder(Node root) {

        ArrayList<Integer> ans =new ArrayList<>();
        Stack<Node> s=new Stack<>();
        Node curr=root;


        while (curr!=null || !s.isEmpty()){

            while (curr!=null){

                s.push(curr);
                curr=curr.left;
            }
            curr=s.pop();
            ans.add(curr.data);

            curr=curr.right;

        }
        return ans;

    }
}
