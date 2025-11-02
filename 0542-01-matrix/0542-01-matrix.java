class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int [][] distance = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j] == 0){
                    q.offer(new int[] {i,j});
                    distance[i][j] = 0;
                }else{
                    distance[i][j] = -1;
                }
            }
        }
        int [] dirs = {-1,0,1,0,-1};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for(int d = 0; d < 4; d++){
                int nextRow = currRow + dirs[d];
                int nextCol = currCol + dirs[d+1];
                if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && distance[nextRow][nextCol] == -1){
                    distance[nextRow][nextCol] = distance[currRow][currCol] + 1;
                    q.offer(new int[] {nextRow,nextCol});
                }
            }
        }
        return distance;
    }
}