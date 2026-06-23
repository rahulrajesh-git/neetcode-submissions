class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];           ///row->colums
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //swap
        for(int i=0;i<n;i++){
            int left=0,right=n-1;

            while(left<right){
                int temp=matrix[i][left];           ///left right see all
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}
