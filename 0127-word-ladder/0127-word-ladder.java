class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordBank = new HashSet<>(wordList);
        if (!wordBank.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                if(word.equals(endWord)){
                    return level;
                }
                for(int j=0;j<word.length();j++){
                    char [] current = word.toCharArray();
                    for(char c='a'; c <= 'z'; c++){
                        current[j] = c;
                        String newWord = new String(current);
                        if(wordBank.contains(newWord)){
                            q.offer(newWord);
                            wordBank.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}