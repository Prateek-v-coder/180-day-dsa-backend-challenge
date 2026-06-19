package projects;

import java.util.ArrayList;
import java.util.Arrays;

public class Generics_stack<T> {
    private ArrayList<T> stack = new ArrayList<>();
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void push(T item){
        stack.add(item);
    }
    public T pop(){
        if (isEmpty()) throw new RuntimeException("stack is empty");
        return stack.remove(stack.size()-1);
    }
    public T peek(){
        if (isEmpty()) throw new RuntimeException("stack is empty");
        return stack.get(stack.size()-1);
    }
    public int getSize(){
        return stack.size();
    }
}
