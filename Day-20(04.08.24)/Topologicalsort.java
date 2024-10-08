class Topologicalsort
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
         int result[]=new int[V];
        boolean vis[]=new boolean[V];
        Stack<Integer> s=new Stack<>();
        int i;
        for(i=0;i<V;i++){
            if(!vis[i]){
                topSortUtil(adj,vis,i,s);
            }
        }
        i=0;
        while(!s.isEmpty()){
            result[i++]=s.pop();
        }
        return result;
    }
    static void topSortUtil(ArrayList<ArrayList<Integer>> adj, boolean vis[], int curr, Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<adj.get(curr).size();i++){
            int next=adj.get(curr).get(i);
            if(!vis[next]){
                topSortUtil(adj,vis,next,s);
            }
        }
        s.push(curr);
    }
}
