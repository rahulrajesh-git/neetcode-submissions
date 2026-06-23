class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }

        int rows=grid.length;
        int cols=grid[0].length;
        int islands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(i,j,grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int row,int col,char[][] grid){
        int m=grid.length;
        int n=grid[0].length;

        if(row<0||row>=m||col<0||col>=n||grid[row][col]=='0'){
            return;
        }

         grid[row][col]='0';///after checking

         dfs(row+1,col,grid);
         dfs(row-1,col,grid);
         dfs(row,col+1,grid);
         dfs(row,col-1,grid);
    }
}
