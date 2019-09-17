class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length!=0){
            int[][] neighs = new int [board.length][board[0].length];
            for(int i = 0; i< board.length; i++){
                for(int j = 0; j<board[0].length; j++){
                    neighs[i][j]=getLiveNeighbors(board, i,j);
                }
            }
            for(int i = 0; i< board.length; i++){
                for(int j = 0; j<board[0].length; j++){
                    int neighbors = neighs[i][j];
                    if(board[i][j]==1 && neighbors<2) board[i][j]=0;
                    else if(board[i][j]==1 && neighbors<4) board[i][j]=1;
                    else if(board[i][j]==1) board[i][j]=0;
                    else if(board[i][j]==0&&neighbors ==3) board[i][j]=1;
                    else board[i][j]=0;
                }
            }
        }
    }
    public int getLiveNeighbors(int[][]board, int i , int j){
        int neighbors = 0;
        if(i>0 &&board[i-1][j]==1)neighbors++;
        if(i>0&&j>0&&board[i-1][j-1]==1)neighbors++;
        if(j>0&&board[i][j-1]==1)neighbors++;
        if(i>0 && j+1<board[0].length&&board[i-1][j+1]==1)neighbors++;
        if(j+1<board[0].length&&board[i][j+1]==1)neighbors++;
        if(i+1<board.length&&j+1<board[0].length&&board[i+1][j+1]==1)neighbors++;
        if(i+1<board.length&&j>0&&board[i+1][j-1]==1)neighbors++;
        if(i+1<board.length&&board[i+1][j]==1)neighbors++;
        
        return neighbors;
    }
}