class DFSofGraph {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         ArrayList<Integer> ans= new ArrayList<>();
        boolean[] vis= new boolean[V+1];
        //vis[0]=true;
        DFS(0, vis,adj, ans);
        return ans;
    }
    public static ArrayList<Integer> DFS(int node, boolean[] vis, 
                                         ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        vis[node]=true;
        ans.add(node);
        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                DFS(it,vis,adj, ans);
            }
        }
        return ans;
    }
}