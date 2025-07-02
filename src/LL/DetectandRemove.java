package LL;

import java.util.HashSet;

public class DetectandRemove {

   static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }


        static void printList(Node curr) {
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
        }
    public static void main(String[] args) {

        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        head.next.next.next.next.next = head.next.next;

        removeLoop(head);
        printList(head);

        removeLoop1(head);
        printList(head);
    }

    private static void removeLoop1(Node node) {
        if (node == null || node.next == null)
            return;

        Node slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        // If loop exists
        if (slow == fast) {
            slow = node;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // since fast->next is the looping point
                // remove loop
                fast.next = null;
            }
            // This case is added if fast and slow
            // pointer meet at first position.
            else {
                while(fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    private static void removeLoop(Node head) {

        HashSet<Node> set=new HashSet<>();
        Node prev=null;

        while (head!=null){

            if (set.contains(head)){
                prev.next=null;
                return;

            }else{
                set.add(head);
                prev=head;
                head=head.next;
            }
        }
    }
}
