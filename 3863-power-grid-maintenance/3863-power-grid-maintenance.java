class Solution {
    int [] parent, size;
    Map<Integer, PriorityQueue<Integer>> map = new HashMap();
    int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }
    void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size[ulp_u] > size[ulp_v]){
            size[ulp_u] += size[ulp_v];
            parent[ulp_v] = ulp_u;
            PriorityQueue<Integer> pqU = map.get(ulp_u);
            PriorityQueue<Integer> pqV = map.get(ulp_v);
            while(!pqV.isEmpty()){
                pqU.offer(pqV.poll());
            }
        }else{
            size[ulp_v] += size[ulp_u];
            parent[ulp_u] = ulp_v;
            PriorityQueue<Integer> pqU = map.get(ulp_u);
            PriorityQueue<Integer> pqV = map.get(ulp_v);
            while(!pqU.isEmpty()){
                pqV.offer(pqU.poll());
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        size = new int[c];
        boolean [] offline = new boolean[c];
        for(int i=0;i<c;i++){
            parent[i] = i;
            size[i] = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(i);
            map.put(i, pq);
        }
        for(int [] conn : connections){
            //need to convert from 1-based indexing
            int u = conn[0] - 1, v = conn[1] - 1;
            unionBySize(u,v);
        }
        List<Integer> res = new ArrayList<>();
        for(int [] q : queries){
            int type = q[0];
            int node = q[1] - 1;
            if(type == 1){
                if(!offline[node]){
                    res.add(node+1);
                    continue;
                }
                int par = findParent(node);
                PriorityQueue<Integer> pq = map.get(par);
                while(!pq.isEmpty() && offline[pq.peek()]) pq.poll();
                res.add(pq.isEmpty() ? -1 : pq.peek() + 1);
            }else{
                offline[node] = true;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}