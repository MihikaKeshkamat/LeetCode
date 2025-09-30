class Solution {
    public int atMost(int [] nums, int k){
        int n = nums.length;
        int left = 0, countOdd = 0, res = 0;
        for(int right = 0; right < n; right++){
            if(nums[right] % 2 != 0){
                countOdd++;
            }
            while(countOdd > k){
                if(nums[left] % 2 != 0){
                    countOdd--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums, k-1);
    }
}