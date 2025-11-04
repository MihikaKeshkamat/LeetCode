class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char [] geneChars = {'A','C','G','T'};
        int level = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0;i<size;i++){
                char [] current = q.poll().toCharArray();
                for(int pos=0;pos<8;pos++){
                    char original = current[pos];
                    for(char c : geneChars){
                        current[pos] = c;
                        String mutated = String.valueOf(current);
                        if(mutated.equals(endGene) && bankSet.contains(mutated)){
                            return level;
                        }
                        if(bankSet.remove(mutated)){
                            q.add(mutated);
                        }
                    } 
                    current[pos] = original;  
                }
            }
        }
        return -1;
    }
}