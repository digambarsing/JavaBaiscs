package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class SingleQueue {
    static Queue<Integer> q=new LinkedList<>();

    public static void push(int x){

        int s=q.size();
        q.add(x);
        for (int i = 0; i < s; i++) {
            q.add(q.remove());
        }

    }

    public static void main(String[] args) {
        push(2);
        push(3);
        push(4);

        System.out.println(q);

        System.out.println(pop());
        System.out.println(q.peek());
    }

    private static int pop() {

        return q.poll();
    }
}
