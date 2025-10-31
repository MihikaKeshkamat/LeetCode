class Solution {
    public int findCircleNum(int[][] isConnected) {
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                stk.push(i);
                while (!stk.isEmpty()) {
                    int curr = stk.peek();
                    stk.pop();
                    vis[curr] = true;
                    for(int j=0;j<isConnected[curr].length; j++){
                        if(!vis[j] && isConnected[curr][j] == 1){
                            stk.push(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}