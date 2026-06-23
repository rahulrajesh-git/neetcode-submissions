class Solution {
    //djikstras
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        boolean[][] visited=new boolean[n][n];///
        PriorityQueue<int[]> minh=new PriorityQueue<>((a,b)->a[0]-b[0]);//time,r,c

        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        minh.offer(new int[]{grid[0][0],0,0});


        while(!minh.isEmpty()){
            int[] cur=minh.poll();
            int curtime=cur[0];
            int r=cur[1];
            int c=cur[2];

            if(visited[r][c]){
                continue;///
            }

            visited[r][c]=true;////

            if(r==n-1&&c==n-1){
                return curtime;////
            }

            
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr<0||nr>=n||nc<0||nc>=n||visited[nr][nc]){
                    continue;
                }

               // not here visited[nr][nc]=true;

                int newtime=Math.max(curtime,grid[nr][nc]);//  curtime maxtime is added at every point so min time is processed if we reach end min time automatically is the result as we use min heap
                minh.offer(new int[]{newtime,nr,nc});
            }
        }

        return -1;
    }
}
