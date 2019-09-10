/*
** Given a 2D matrix matrix, find the sum of the elements inside the rectangle 
** defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/
class NumMatrix {
    int [][] dp =null;
    public NumMatrix(int[][] matrix) {
        if(matrix.length != 0) {
            dp = new int[matrix.length][matrix[0].length];
            dp[0][0]= matrix[0][0];
            for(int i = 0; i<matrix.length;i++){
                for(int j = 0; j<matrix[0].length; j++){
                    if(i>0&&j>0){
                        dp[i][j] = dp[i][j-1] + dp[i -1][j] 
                                - dp[i-1][j-1]
                                + matrix[i][j];
                    }
                    else if(i==0&&j>0){
                        dp[i][j] = dp[i][j-1] + matrix[i][j];
                    }
                    else if(j==0 &&i>0){
                        dp[i][j] = dp[i -1][j] + matrix[i][j];
                    }
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1!=0&&row2!=0&&col1!=0&&col2!=0)
            return dp[row2][col2] 
                - dp[row2][col1-1] 
                - dp[row1-1][col2] 
                + dp[row1-1][col1-1];
        if(row1 == 0 && col1 == 0)
            return dp[row2][col2];
        else if(col1 != 0)
            return dp[row2][col2] 
                - dp[row2][col1-1] ;
        else if(row1 != 0)
            return dp[row2][col2] 
                - dp[row1-1][col2];            
        return -1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */