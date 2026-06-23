class KthLargest {
    private PriorityQueue<Integer> minheap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap=new PriorityQueue<>();
        

        for(int num:nums){
          add(num);   // IMPORTANT: use add logic
        }
        
       }
    
    public int add(int val) {
        minheap.offer(val);

        if(minheap.size()>k){  //
            minheap.poll();  // removes smallest
        }

       return minheap.peek();
    }
}
