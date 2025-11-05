class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int [] left, int [] right){
                return getDistance(right) - getDistance(left);
                //if rightD > leftD -> pos number -> has higher priority
                //else if leftD > rightD -> neg number -> left has higher priority
            }
        });
        int [][] res = new int[k][2];
        for(int [] point : points){
            heap.add(point);
            if(heap.size() > k){
                heap.poll();
            }
        }
        while(k-- > 0){
            res[k] = heap.poll();
        }
        return res;
    }
    public int getDistance(int [] point){
        //calculate x^2 + y^2 to compare instead of the expensive euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}