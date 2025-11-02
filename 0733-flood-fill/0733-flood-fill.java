class Solution {
    private static void fill(int[][] image, int sr, int sc, int color, int curr){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if(curr != image[sr][sc]) return;
        image[sr][sc] = color;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        for(int d = 0; d < 4; d++){
            int nextRow = sr + delRow[d];
            int nextCol = sc + delCol[d];
            if(nextRow >=0 && nextRow < image.length && nextCol >= 0 && nextCol < image[0].length && image[nextRow][nextCol] != color){
                fill(image, nextRow, nextCol, color, curr);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}