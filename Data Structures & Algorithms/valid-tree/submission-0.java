class Solution {
    public boolean dfs(List<List<Integer>> adj,boolean[] visited,int u,int parent){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(v == parent) continue;
            if(visited[v]) return true;
            if(dfs(adj,visited,v,u)) return true;
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
       if(dfs(adj,visited,0,-1)) return false;

       for(int i = 0;i < n;i++){
            if(!visited[i]){
                return false;
            }
       }
       return true;
    }
}
