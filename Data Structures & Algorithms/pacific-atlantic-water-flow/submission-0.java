class Solution {
    int[][] heights;
    boolean[][] pacific;
    boolean[][] atlantic;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        this.heights=heights;

        pacific=new boolean[rows][cols];
        atlantic=new boolean[rows][cols];

        for(int c=0;c<cols;c++){
            dfs(0,c,pacific);
        }

        for(int r=0;r<rows;r++){
            dfs(r,0,pacific);
        }

        for(int r=0;r<rows;r++){
            dfs(r,cols-1,atlantic);
        }

        for(int c=0;c<cols;c++){
            dfs(rows-1,c,atlantic);
        }

        List<List<Integer>> res=new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c]&&atlantic[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

        private void dfs(int r,int c,boolean[][] ocean){
            ocean[r][c]=true;

            int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0||nc<0||nr>=ocean.length||nc>=ocean[0].length){
                    continue;
                }

                if(ocean[nr][nc]){
                    continue;
                }

                if(heights[nr][nc]<heights[r][c]){//
                    continue;
                }

                dfs(nr,nc,ocean);
            }
        }
}
