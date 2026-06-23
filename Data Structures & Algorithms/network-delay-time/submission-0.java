class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph=new HashMap<>();//List<int[]>
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->a[0]-b[0]);// time,node stored

        for(int[] t:times){
            graph.computeIfAbsent(t[0],x->new ArrayList<>()).add(new int[]{t[1],t[2]});//node,time
        }

        minheap.offer(new int[]{0,k});//new int[] time,node
        Set<Integer> visited=new HashSet<>();///
        int t=0;

        while(!minheap.isEmpty()){
            int[] cur=minheap.poll();
            int curtime=cur[0];
            int node=cur[1];

            if(visited.contains(node)){
                continue;
            }

            visited.add(node);//
            t=curtime;///

            if(graph.containsKey(node)){
                for(int[] nei:graph.get(node)){//.get
                    int next=nei[0];
                    int w=nei[1];

                    if (!visited.contains(next)) {///
                        minheap.offer(new int[]{curtime + w, next});// curtime+w
                    }
                }
            }
        }

        return visited.size()==n?t:-1;
    }
}
