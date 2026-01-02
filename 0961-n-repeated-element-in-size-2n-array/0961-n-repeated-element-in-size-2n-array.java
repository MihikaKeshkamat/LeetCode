class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1] || (i + 2 < nums.length && nums[i] == nums[i+2])){
                return nums[i];
            }
        }
        return nums[0];
    }
}