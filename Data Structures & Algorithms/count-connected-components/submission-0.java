class Solution {
    public void dfs(List<List<Integer>> adj,boolean[] visited,int u){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj,visited,v);
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
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

        int result = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                dfs(adj,visited,i);
                result++;
            }
        }
        return result;
    }
}
