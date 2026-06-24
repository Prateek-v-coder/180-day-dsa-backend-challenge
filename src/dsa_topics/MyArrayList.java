package dsa_topics;
public class MyArrayList<T>{
    private int capacity = 4;
    private int size;
    private T[] items;
    public MyArrayList(){
        items = (T[]) new Object[capacity];
        size = 0;
    }
    public void resize(){
        capacity=capacity*2;
        T[] newArr = (T[]) new Object[capacity];
        for (int i =0; i<items.length; i++){
            newArr[i]=items[i];
        }
        items=newArr;
    }
    public int size(){
        return size;
    }
    public void add(T data){
        if (size()==capacity){
            resize();
        }
        items[size()] = data;
        size++;
    }
    public void add(int idx,T data){
        if (idx<0||idx>=size()){
            throw new IndexOutOfBoundsException("Index"+idx);
        }
        if (size()==capacity){
            resize();
        }
        for (int i = size()-1; i>=idx; i--){
            items[i+1]=items[i];
        }
        items[idx]=data;
        size++;
    }
    public void update(int idx,T data){
        if (idx<0||idx>=size()){
            throw new IndexOutOfBoundsException("Index"+idx);
        }
        items[idx]=data;
    }
    public void remove(int idx){
        if (idx<0||idx>size()){
            throw new IndexOutOfBoundsException("Index"+idx);
        }
        for (int i = idx; i<size()-1; i++){
            items[i]=items[i+1];
        }
        size--;
    }
    public boolean contains(T data){
        for (int i = 0;i<size(); i++){
            if (items[i].equals(data)) return true;
        }
        return false;
    }
    public void print(){
        System.out.print("[");
       for (int i =0; i<size; i++){
           System.out.print(items[i]+" ");
       }
        System.out.print("]");
    }
}
