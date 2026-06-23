class MedianFinder {
    private PriorityQueue<Integer> smallheap;
    private PriorityQueue<Integer> largeheap;

    public MedianFinder() {
        smallheap=new PriorityQueue<>((a,b)->b-a);
        largeheap=new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        smallheap.add(num);
        if(smallheap.size()-largeheap.size()>1 || !largeheap.isEmpty()&&smallheap.peek()>largeheap.peek()){
            largeheap.add(smallheap.poll());
        }
        if(largeheap.size()-smallheap.size()>1){
            smallheap.add(largeheap.poll());
        }
    }
    
    public double findMedian() {
        if(smallheap.size()==largeheap.size()){
            return (double)(smallheap.peek()+largeheap.peek())/2.0;
        }
        else if(smallheap.size()>largeheap.size()){
            return (double) smallheap.peek();
        }
        else{
            return (double) largeheap.peek();
        }
        }
    }

