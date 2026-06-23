class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();

        for(int s:stones){
            minheap.offer(-s);
        }

        while(minheap.size()>1){
            int first=minheap.poll();/// -8 -7 -6 ...-8 will be popped
            int second=minheap.poll();

            if(second>first){
                minheap.offer(first-second); // bcz we get  -8-(-7)=-1 which will be beyond -6 
            }
        }

        minheap.offer(0);
        return Math.abs(minheap.poll());
    }
}
