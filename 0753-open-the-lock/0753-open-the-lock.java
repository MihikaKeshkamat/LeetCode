class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")){
            return -1;
        }
        Deque<String> q = new ArrayDeque<>();
        q.offer("0000");
        int ans = 0;
        visited.add("0000");
        while(!q.isEmpty()){
            ans++;
            int level = q.size();
            for(int i=0;i<level;i++){
                String curr = q.poll();
                for(String next : nextComb(curr)){
                    if(next.equals(target)){
                        return ans;
                    }
                    if(!visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }
    public List<String> nextComb(String curr){
        List<String> res = new ArrayList<>();
        char [] digits = curr.toCharArray();
        for(int wheelIdx = 0; wheelIdx < 4; wheelIdx++){
            char original = digits[wheelIdx];
            //turn it backwards
            digits[wheelIdx] = original == '0' ? '9' : (char) (original - 1);
            res.add(String.valueOf(digits));
            //turn it forwards
            digits[wheelIdx] = original == '9' ? '0' : (char) (original + 1);
            res.add(String.valueOf(digits));
            //restore
            digits[wheelIdx] = original;
        }
        return res;
    }
}