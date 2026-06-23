class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        Map<Integer,List<int[]>> adj=new HashMap<>();

        for(int i=0;i<n;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=i+1;j<n;j++){
                int x2=points[j][0];
                int y2=points[j][1];
                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
                adj.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{dist,j});
                adj.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{dist,i});// must do for both points
            }
        }


        PriorityQueue<int[]> minh=new PriorityQueue<>((a,b)->a[0]-b[0]);
        minh.offer(new int[]{0,0});

        int mincost=0;
        Set<Integer> visited=new HashSet<>();

        while(visited.size()<n){
            int[] cur=minh.poll();
            int cost=cur[0];
            int point=cur[1];

            if(visited.contains(point)){
                continue;
            }

            visited.add(point);
            mincost+=cost;

            for(int[] nei:adj.getOrDefault(point, new ArrayList<>())){// should use getordefault otherwise error comes for absentnodes
               // int neicost=nei[0];
               // int neipoint=nei[1];

                if(!visited.contains(nei[1])){
                    minh.offer(new int[]{nei[0],nei[1]});
                }
            }

        }

        return mincost;
    }
}
