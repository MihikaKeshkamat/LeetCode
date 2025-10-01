class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean [][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0 || i == rows - 1 || j == 0 || j == cols - 1){
                    pq.offer(new int [] {heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }
        int totalWater = 0;
        int [] directions = {-1,0,1,0,-1};
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int currHeight = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];
            for(int k = 0; k < 4; k++){
                int nextRow = currRow + directions[k];
                int nextCol = currCol + directions[k+1];
                if(nextRow > 0 && nextRow < rows && nextCol > 0 && nextCol < cols && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol] = true;
                    totalWater += Math.max(0, currHeight - heightMap[nextRow][nextCol]);
                    pq.offer(new int [] {Math.max(currHeight,heightMap[nextRow][nextCol]),nextRow,nextCol});
                }
            }
        }
        return totalWater;
    }
}