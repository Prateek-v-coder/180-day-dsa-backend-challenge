package sorting;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,8,9,3,6,7,0,8};
        divide(arr,0,arr.length-1);
        for (int i =0; i<arr.length; i++){
          System.out.print(arr[i]+" ");
        }
    }
    public static void divide(int[] arr,int low ,int high){
        if (low>=high) return;
        int mid = low+(high-low)/2;
        divide(arr,low,mid);
        divide(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k=0;
        while(left<=mid&&right<=high){
            if (arr[left]<=arr[right]){
                temp[k++]=arr[left++];
            }else {
                temp[k++]=arr[right++];
            }
        }
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while(right<=high){
            temp[k++]=arr[right++];
        }
        for (int i =0; i<temp.length; i++){
            arr[low+i]=temp[i];
        }
    }
}
