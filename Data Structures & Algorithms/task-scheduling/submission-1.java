class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Comparator.reverseOrder());//
        Queue<int[]> q=new LinkedList<>();// cnt,nextstarttime   // normal q

        int[] freq=new int[26];//
        for(char c:tasks){
            freq[c-'A']++;
        }

        for(int f:freq){
            if(f>0){
                maxheap.offer(f);//
            }
        }

        int time=0;
        while(!maxheap.isEmpty()||!q.isEmpty()){
            time++;

            if(!maxheap.isEmpty()){
                int cnt=maxheap.poll();//poll
                cnt--;

                if(cnt>0){
                    q.offer(new int[]{cnt,time+n});//
                }
            }

            if(!q.isEmpty()&&q.peek()[1]==time){
                maxheap.offer(q.poll()[0]);
            }
        }
        return time;

    }
}
