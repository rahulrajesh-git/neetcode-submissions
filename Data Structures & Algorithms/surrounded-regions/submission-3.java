class Solution {
    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;

        //o to t
        for(int r=0;r<rows;r++){
            if(board[r][0]=='O'){//r 0       left
                capture(board,r,0);
            }
            if(board[r][cols-1]=='O'){//r cols -1      right
                capture(board,r,cols-1);
            }
        }

        for(int c=0;c<cols;c++){
            if(board[0][c]=='O'){   //  top
                capture(board,0,c);
            }
            if(board[rows-1][c]=='O'){   // bottom
                capture(board,rows-1,c);
            }
        }

        // o to x
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        //t to o
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void capture(char[][] board,int r,int c){
            if(r<0||r>=board.length||c<0||c>=board[0].length||board[r][c]!='O'){//!='O'
                return;
            }
            board[r][c]='T';
            capture(board,r+1,c);
            capture(board,r-1,c);
            capture(board,r,c+1);
            capture(board,r,c-1);
        }
}
