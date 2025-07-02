package BT;

import java.util.Stack;

public class Pdbuild {
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
    static int index=-1;
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node ans=build(nodes);

        pre(ans);
        System.out.println();
        preite(ans);
        System.out.println();
        inite(ans);
        System.out.println();
        posite(ans);

    }
    private static void posite(Node ans){

        if (ans==null) return;
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();

        st1.push(ans);
        while (!st1.isEmpty()){
            Node curr=st1.pop();
            st2.push(curr);
            if (curr.left!=null) st1.push(curr.left);
            if (curr.right!=null) st1.push(curr.right);
        }

        while (!st2.isEmpty()){
            System.out.print(st2.pop().data+" ");
        }
    }

    private static void inite(Node ans) {

        if (ans==null) return;

        Stack<Node>st=new Stack<>();
        Node curr=ans;
        while (curr!=null || !st.isEmpty()){
            while (curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }

    private static void preite(Node ans) {
        Stack<Node>st=new Stack<>();
        st.push(ans);

        while (!st.isEmpty()){
            Node curr=st.pop();
            System.out.print(curr.data+" ");
            if (curr.right!=null)st.push(curr.right);
            if (curr.left!=null)st.push(curr.left);
        }
    }

    private static void pre(Node ans) {
        if (ans==null) return;
        System.out.print(ans.data+" ");
        pre(ans.left);

        pre(ans.right);
    }

    private static Node build(int[] nodes) {
        index++;
        if (nodes[index]==-1){
            return null;
        }else{
            Node nn=new Node(nodes[index]);
            nn.left=build(nodes);
            nn.right=build(nodes);
            return nn;
        }

    }
}
