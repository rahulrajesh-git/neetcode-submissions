class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        backtrack(0,board,res);
        return res;
    }

    private void backtrack(int r,char[][] board,List<List<String>> res){
        if(r==board.length){//not board.length-1
            List<String> copy=new ArrayList<>();

            for(char[] row:board){  //
                copy.add(new String(row));//new String
            }
            res.add(copy);
            return;
        }

        for(int c=0;c<board.length;c++){//
            if(issafe(r,c,board)){
                board[r][c]='Q';
                backtrack(r+1,board,res);
                board[r][c]='.';
            }
        }

    }

    private boolean issafe(int r,int c,char[][] board){
        /*horizontal
        for(int i=0;i<board.length;i++){
            if(board[r][i]=='Q'){
                return false;
            }
        }*/

        //vertical
        for(int j=0;j<r;j++){//r
            if(board[j][c]=='Q'){
                return false;
            }
        }

        //left diagonal
        for(int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--){//
                if(board[i][j]=='Q'){
                    return false;
                }
        }

        //right diagonal
         for(int i = r-1, j = c+1; i >= 0 && j < board.length; i--, j++){
                if(board[i][j]=='Q'){
                    return false;
                }
        }
        return true;
    }
}
