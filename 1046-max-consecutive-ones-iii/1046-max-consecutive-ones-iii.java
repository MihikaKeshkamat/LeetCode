class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int count = 0;
        int maxLen = 0;
        for(int end=0;end<n;++end){
            if(nums[end] == 0){
                count++;
            }
            while(count > k){
                if(nums[start] == 0){
                    count--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}