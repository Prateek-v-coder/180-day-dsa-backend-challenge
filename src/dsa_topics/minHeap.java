package dsa_topics;

public class minHeap {
    public static void main(String[] args) {
        minHeap min = new minHeap(10);
        min.insert(40);
        min.insert(10);
        min.insert(20);
        min.insert(30);
        System.out.println(min.peek());
        System.out.println(min.remove());
        System.out.println(min.peek());
    }
    private int arr[];
    private int size;
    private int capacity;
    minHeap(int capacity){
        this.capacity=capacity;
        arr = new int[capacity];
        size=0;
    }
    void swap(int a , int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b] = temp;
    }
    int parent(int i){return (i-1)/2;}
    int leftChild(int i){return 2*i+1;}
    int rightChild(int i ){return 2*i+2;}
    void insert(int val){
        arr[size++]=val;
        int current = size-1;
        while (current>0){
            if(arr[parent(current)]<=arr[current]) break;
            swap(parent(current),current);
            current=parent(current);
        }
    }
    int remove(){
        int min = arr[0];
        arr[0] =arr[size-1];
        size--;
        heapifyDown(0);
        return min;
    }
    void heapifyDown(int i){
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        if(left<size&&arr[left]<arr[smallest]){
            smallest=left;
        }
        if(right<size&&arr[right]<arr[smallest]){
            smallest=right;
        }
        if(smallest!=i){
            swap(i,smallest);
            heapifyDown(smallest);
        }
    }
    int peek(){
        if (size==0){
            System.out.println("heap is empty");
        }
        return arr[0];
    }
    boolean isEmpty(){
        return size==0;
    }
}
