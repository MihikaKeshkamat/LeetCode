class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0L;
        for(int b : batteries){
            sum += b;
        }
        long low = 0L;
        long high = sum/n;
        while(low < high){
            long mid = (low+high+1)/2;
            long use = 0L;
            for(int b : batteries){
                use += Math.min((long)b,mid);
                if(use >= mid * n) break;
            }
            if(use >= mid * n){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}