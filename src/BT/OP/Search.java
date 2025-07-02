package BT.OP;

public class Search  extends Insertion{
    public static void main(String[] args) {
        Node root = new Node(2);
        root.l = new Node(3);
        root.r = new Node(4);
        root.l.l = new Node(5);
      boolean ans=  searching(root,8);
        System.out.println(ans?1:0);
    }

    private static boolean searching(Node root, int key) {
        if (root==null) return false;
        if (root.val==key) return true;

        return searching(root.l,key) || searching(root.r,key);
    }
}
