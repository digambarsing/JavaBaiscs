package Stack;

import java.util.Stack;

public class swap {
    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s);

        Stack<Integer>ss=new Stack<>();
        ss.push(13);
        ss.push(23);
        ss.push(33);
        ss.push(34);


        System.out.println(ss);

        Stack<Integer>temp=new Stack<>();
        temp=s;
        s=ss;
        ss=temp;


        System.out.println(s);
//        System.out.println(ss);
    }
}
