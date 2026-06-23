class KthLargest {
    private PriorityQueue<Integer> minheap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap=new PriorityQueue<>();
        

        for(int num:nums){
          add(num);   // IMPORTANT: use add logic   // only stores k elements
        }
        
       }
    
    public int add(int val) {
        minheap.offer(val);

        if(minheap.size()>k){  //
            minheap.poll();  // removes smallest 1 2 3 removes 1
        }

       return minheap.peek(); // returns 2 if k=2
    }
}
