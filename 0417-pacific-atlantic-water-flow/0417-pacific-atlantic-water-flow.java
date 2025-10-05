class Solution {
    private int [][] heights;
    private int rows;
    private int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        this.heights = heights;
        Deque<int []> pacific = new LinkedList<>();
        Deque<int []> atlantic = new LinkedList<>();
        Set<Integer> visitedP = new HashSet<>();
        Set<Integer> visitedA = new HashSet<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i == 0 || j == 0){ 
                    int value = i*cols + j;
                    pacific.offer(new int [] {i,j});
                    visitedP.add(value);
                }
                if(i == rows - 1 || j == cols - 1){ 
                    int value = i * cols + j;
                    atlantic.offer(new int [] {i,j});
                    visitedA.add(value);
                }
            }
        }
        bfs(pacific,visitedP);
        bfs(atlantic,visitedA);

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int pos = i * cols + j;
                if(visitedP.contains(pos) && visitedA.contains(pos)){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public void bfs(Deque<int []> ocean, Set<Integer> visited){
        int [] directions = {-1,0,1,0,-1};
        while(!ocean.isEmpty()){
            int level = ocean.size();
            for(int i=0;i<level;i++){
                int [] curr = ocean.poll();
                int currRow = curr[0];
                int currCol = curr[1];
                for(int dir = 0; dir < 4; dir++){
                    int nextRow = currRow + directions[dir];
                    int nextCol = currCol + directions[dir+1];
                    int pos = nextRow * cols + nextCol;
                    if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited.contains(pos) && heights[nextRow][nextCol] >= heights[currRow][currCol]){
                        visited.add(pos);
                        ocean.offer(new int [] {nextRow, nextCol});
                    }
                }
            }
        }
    }
}