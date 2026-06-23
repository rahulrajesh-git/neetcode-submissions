class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minheap=new PriorityQueue<>(Comparator.comparing(a->a[0]));//.comparing(a->a[0])
                      //int[]
        for(int[] point:points){
            int dist=point[0]*point[0]+point[1]*point[1];//
            minheap.offer(new int[]{dist,point[0],point[1]});// int[] {}  dont forget []
        }

        int[][] res=new int[k][2];//
        for(int i=0;i<k;i++){
            int[] point=minheap.poll();
            res[i]=new int[]{point[1],point[2]};//  []
        }

        return res;
    }
}
