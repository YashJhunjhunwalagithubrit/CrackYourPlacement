class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second = second;
    }
}
class UndirectedGraphCycle {
    public boolean check(int i,int V, ArrayList<ArrayList<Integer>> adj,boolean[]vis){
        vis[i]=true;//make it as visited
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1));//starting from statr node assume parent as -1
        while(!q.isEmpty()){
            int node = q.peek().first; //get cur node and parent node 
            int parent = q.peek().second;
            q.remove();// remove it from q 
            for(int adjacent:adj.get(node)){ // check for its adjacent nodes
                if(vis[adjacent]==false){ // if adjacent node is not visited
                    vis[adjacent]=true;// visit it and add to queue
                    q.add(new Pair(adjacent,node));
                }else if(parent!=adjacent){ // if adjacent node is visited 
                    return true; //and it is not visited by its parent
                }//it means it is visited by some one else so there is a cyle return true
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean [] vis = new boolean[V];
        //intially all are unvisited
        for(int i=0;i<V;i++){
            vis[i]=false;
        }
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(check(i,V,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}