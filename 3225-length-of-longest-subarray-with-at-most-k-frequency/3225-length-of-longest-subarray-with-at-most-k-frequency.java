class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int start = 0, end = 0;
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(end < n){
            map.put(nums[end], map.getOrDefault(nums[end],0)+1);
            while(map.get(nums[end]) > k){
                map.put(nums[start], map.get(nums[start]) -1);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                start++;
            }
            int curr = end - start + 1;
            maxLen = Math.max(maxLen, curr);
            end++;
        }
        return maxLen;
    }
}