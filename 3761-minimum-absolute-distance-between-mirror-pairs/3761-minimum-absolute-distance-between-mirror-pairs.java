class Solution {
    public int reverse(int a){
        int b = 0;
        while(a > 0){
            b = b * 10 + a % 10;
            a /= 10;
        }
        return b;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int count = Integer.MAX_VALUE;
        for(int i = 0; i< n; i++){
            if(map.containsKey(nums[i])){
                count = Math.min(count, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]),i);
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }
}