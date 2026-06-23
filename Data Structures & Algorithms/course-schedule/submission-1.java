class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());//add
        }

        for(int[] pre:prerequisites){
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){///
                q.add(i);
            }
        }

        int finished=0;

        while(!q.isEmpty()){
            int node=q.poll();
            finished++;//
            for(int nei:adj.get(node)){///
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        return finished==numCourses;
    }
}
