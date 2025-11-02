class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n+1];
        q.offer(0);
        vis[0] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++){
                int curr = q.poll();
                for(int j=1;j*j<=n;j++){
                    int next = curr + j*j;
                    if(next == n){
                        return level;
                    }
                    if(next < n && !vis[next]){
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return level;
    }
}