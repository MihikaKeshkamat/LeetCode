class Solution {
    static void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1'){
            return;
        }
        //optimization - not having to use a visited array
        grid[x][y] = '*'; //destroy the cell so as the save memory 
        //call dfs on all adjacent neighbors
        dfs(grid, x + 1, y);
        dfs(grid, x-1, y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }
}