class Solution {
    private static int n;
    private static int [] dx = {1,0,0,-1};
    private static int [] dy = {0,1,-1,0};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = grid[0][0];
        int high = 1_000_000_000;
        int res = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            boolean [][] vis = new boolean[n][n];
            if(possible(0,0,grid,mid,vis)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static boolean possible(int i, int j, int[][] grid, int time, boolean [][] vis){
        if(i < 0 || j < 0 || i >= n || j >= n || vis[i][j] || grid[i][j] > time){
            return false;
        }
        vis[i][j] = true;
        boolean res = false;
        if(i == n - 1 && j == n - 1){
            return true;
        }
        for(int k=0;k<4;k++){
            res = res || possible(i + dx[k], j + dy[k], grid, time, vis);
        }
        return res;
    }
}