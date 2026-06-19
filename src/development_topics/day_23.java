package development_topics;

import projects.Generics_stack;

public class day_23 {
    public static void main(String[] args) {
        Generics_stack<Integer> stack = new Generics_stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
