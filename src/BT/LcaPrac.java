package BT;

import java.util.ArrayList;

public class LcaPrac extends LCA {
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

        int ans = lca(root, n1, n2);
        if (ans != -1) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + ans);
        } else {
            System.out.println("LCA does not exist");
        }
        Node ans1=lca2(root,n1,n2);
        System.out.println(ans1.data+" ");
    }

    private static Node lca2(Node root,int n1,int n2){
        if (root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node l=lca2(root.left, n1, n2);
        Node r=lca2(root.right, n1, n2);

        if (l==null) return r;
        if (r==null) return l;
        return root;
    }

    private static int lca(Node root, int n1, int n2) {
        ArrayList<Integer>a1=new ArrayList<>();
        ArrayList<Integer>a2=new ArrayList<>();

        if(!getPath(root,n1,a1) || !getPath(root,n2,a2)){
            return -1;
        }
        int i=0;
        for(;i< a1.size() &&i< a2.size();i++){
            if (!a1.get(i).equals(a2.get(i))){
                break;
            }
        }
        return a1.get(i-1);
    }

    private static boolean getPath(Node root, int n, ArrayList<Integer> a) {
        if (root==null) return false;
        a.add(root.data);
        if (root.data == n) {
            return true;
        }
        if (root.left!=null && getPath(root.left,n,a)) return true;
        if (root.right!=null && getPath(root.right,n,a)) return true;

        a.remove(a.size()-1);
        return false;
    }
}
