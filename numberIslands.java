/* 
** Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
** An island is surrounded by water and is formed by connecting adjacent lands horizontally 
** or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

class Solution {
    boolean[][] checked;
    public int numIslands(char[][] grid) {
        if(grid.length ==0)return 0;
        checked = new boolean[grid.length][grid[0].length];
        return helper(grid, 0,0,0);
    }
    public int helper(char[][] grid, int i, int j, int count){
        if(i>=grid.length) return count;
        if(!checked[i][j] && grid[i][j]=='1'){
            markIsland(grid, i,j);
            count++;
        }
        if(j+1<grid[0].length)j++;
        else{
            i++; 
            j=0;
        }
        
        return helper(grid, i, j, count);
    }
    public void markIsland(char[][] grid, int i, int j){
        if(!(i<0 || j<0 ||i>=grid.length||j>=grid[0].length)&&grid[i][j]=='1'&&!checked[i][j]){
                checked[i][j] = true;
                markIsland(grid, i-1,j);
                markIsland(grid,i+1,j);
                markIsland(grid, i,j-1);
                markIsland(grid, i, j+1);
        }
    }
}