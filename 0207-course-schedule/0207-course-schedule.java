class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] vis = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(b).add(a);
        }
        int [] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int [] topo = new int[numCourses];
        int count = 0, i = 0;
        while(!q.isEmpty()){
            Integer node = q.peek();
            q.remove();
            topo[i++] = node;
            count++;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return count == numCourses ? true : false;
    }
}