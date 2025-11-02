class Solution {
    private static int dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] || grid[r][c] == 0) {
            return 0;
        }
        vis[r][c] = true;
        return 1 + dfs(grid, vis, r + 1, c) + dfs(grid, vis, r - 1, c)
                + dfs(grid, vis, r, c + 1) + dfs(grid, vis, r, c - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, vis, i, j));
                }
            }
        }
        return maxArea;
    }
}