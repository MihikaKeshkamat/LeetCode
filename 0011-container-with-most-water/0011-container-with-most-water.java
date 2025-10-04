class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0;
        int right = height.length - 1;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * h;
            max = Math.max(area,max);
            while(left < right && h == height[left]){
                left++;
            }
            while(left < right && h == height[right]){
                right--;
            }
        }
        return max;
    }
}