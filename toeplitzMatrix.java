class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            int length = Math.min(i, matrix[0].length);
            if(i == 0) length = matrix[0].length;
            for(int j = 0; j< length; j++){
                if(!checkDiag(matrix, i, j, matrix[i][j])) return false; //check diags from top row
            }
        }
        return true;
    }
    public boolean checkDiag(int [][] matrix, int i, int j, int value){
        if(i>=matrix.length || j>=matrix[0].length) return true;
        if(matrix[i][j]!=value) return false;
        else{
            return checkDiag(matrix, i+1, j+1, value);
        }
        
    }
}