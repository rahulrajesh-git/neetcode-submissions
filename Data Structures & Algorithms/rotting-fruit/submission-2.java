class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int rows=grid.length,cols=grid[0].length;
        int fresh=0,time=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()&&fresh>0){
            int size=q.size();// otherwise size will change
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int r=cur[0];
                int c=cur[1];

                for(int[] d:dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr<0||nr>=rows||nc<0||nc>=cols||grid[nr][nc]==0){//>=
                        continue;
                    }
                    if(grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                       
                    }
                   
                }
                
            }
              time++;// placement
        }

        if(fresh>0){
            return -1;
        }else{
            return time;
        }
    }
}
