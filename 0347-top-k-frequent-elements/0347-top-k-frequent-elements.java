class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        if(k == nums.length) return nums;
        for(int val : map.keySet()){
            pq.add(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}