class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = height[0];
        int rMax = height[n-1];
        int left = 1, right = n-2;
        int result = 0;
        while(left <= right){
            if(lMax <= rMax){
                result += Math.max(0, lMax - height[left]);
                lMax = Math.max(lMax, height[left]);
                left++;
            }
            else{
                result += Math.max(0, rMax - height[right]);
                rMax = Math.max(rMax, height[right]);
                right--;
            }
        }
        return result;
    }
}