class Solution {
     int[] parent;
     int [] rank;
    public int countComponents(int n, int[][] edges) {
       parent=new int[n];
       rank=new int[n];

       for(int i=0;i<n;i++){
        parent[i]=i;
        rank[i]=1;
       }

       int components=n;

       for(int[] e:edges){
        if(union(e[0],e[1])){
            components--;
        }
       }

        return components;
    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    private boolean union(int a,int b){
        int pa=find(a);
        int pb=find(b);

        if(pa==pb){
            return false;
        }

        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }else{
             parent[pb] = pa;
             rank[pa]++;
        }
        return true;
    }
}
