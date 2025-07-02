package LL;

public class mergetwosoted {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // First linked list: 5 -> 10 -> 15 -> 40
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);

        // Second linked list: 2 -> 3 -> 20
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node res = sortedMerge(head1, head2);
        System.out.println("hello");
        printList(res);
//        Node res2 = sortedMerge2(head1, head2);
//        printList(res2);
    }

    private static Node sortedMerge2(Node head1, Node head2) {
        if (head1==null) return head2;
        if (head2==null) return head1;
        Node dummy=new Node(-1);
        Node curr=dummy;

        while (head1!=null && head2!=null){
            if (head1.data<= head2.data){
                curr.next=head1;
                head1=head1.next;
            }else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;

        }

        if (head1!=null){
            curr.next=head1;
        }else {
            curr.next=head2;
        }

        return dummy.next;
    }

    private static Node sortedMerge(Node head1, Node head2) {

        if (head1==null) return head2;
        if (head2==null) return head1;

        if (head1.data<= head2.data){
            head1.next=sortedMerge(head1.next,head2);
            return head1;
        }else{
            head2.next=sortedMerge(head1,head2.next);
            return head2;
        }
    }
}
