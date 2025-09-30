class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        HashSet<Integer> result = new HashSet<>();
        for(int x : nums2){
            if(set.contains(x)){
                result.add(x);
            }
        }
        int [] res = new int[result.size()];
        int i = 0;
        for(int x : result){
            res[i++] = x;
        }
        return res;
    }
}