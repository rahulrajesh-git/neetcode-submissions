class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int INF=2147483647;

        int rows=grid.length,cols=grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    q.offer(new int[]{r,c});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};//

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];

            for(int[] d:dirs){
                int nr=r+d[0];//
                int nc=c+d[1];

                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols ||grid[nr][nc]!=INF){//here we use inf
                    continue;
                }

                grid[nr][nc]=grid[r][c]+1;/// updating values
                q.offer(new int[]{nr,nc});
            }
        }

    }
}
