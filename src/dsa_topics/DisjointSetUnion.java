package dsa_topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DisjointSetUnion {
    private int n;
    private int[] parent;
    private int[] rank;
    public DisjointSetUnion(int n){
        this.n=n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i<n; i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public void unionByRank(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA==parentB) return;
        if(rank[parentA]== rank[parentB]){
            parent[parentB]=parentA;
            rank[parentA]++;
        } else if (rank[parentA] > rank[parentB]) {
            parent[parentB]=parentA;
        }else{
            parent[parentA]=parentB;
        }
    }
    public int find(int x){
       if(parent[x]==x) return x;
       parent[x] = find(parent[x]);
       return parent[x];
    }

    public static void main(String[] args) {
        DisjointSetUnion ds = new DisjointSetUnion(6);
        System.out.println(ds.find(0));
        System.out.println(ds.find(1));
        ds.unionByRank(0,1);
        System.out.println(ds.find(1));
    }

}
