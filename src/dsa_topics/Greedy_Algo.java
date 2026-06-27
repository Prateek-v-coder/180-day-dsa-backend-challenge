package dsa_topics;

import java.util.Arrays;

public class Greedy_Algo {
    public int activitySelection(int[] start,int [] end){
       int n = start.length;
       Integer[] indices = new Integer[n];
       for (int i =0; i<n; i++){
           indices[i]=i;
       }
       Arrays.sort(indices,(a,b)->end[a]-end[b]);
       int count = 1;
       int lastEnd = end[indices[0]];
       for (int i =1; i<n; i++){
           int idx = indices[i];
           if(start[idx]>=lastEnd){
               count++;
               lastEnd=end[idx];
           }
       }
       return count;
    }
    public static double fractionalKnapsack(int[] values,int[] weights,int w){
        int n = values.length;
        Integer[] idx = new Integer[n];
        for (int i =0; i<n; i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->Double.compare((double)values[b]/weights[b],(double)values[a]/weights[a]));
        double totalValue = 0;
        for(int i =0; i<n; i++){
            int id = idx[i];
            if(w>=weights[id]){
                totalValue+=values[id];
                w-=weights[id];
            }else {
                totalValue+=(double)values[id]/weights[id]*w;
                break;
            }
        }
        return totalValue;
    }
}
