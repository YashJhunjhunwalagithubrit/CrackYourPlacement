class PrerequisiteTasks {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int Indeg[] = new int[N];
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<Integer>());
            
        }
        
        for(int i=0;i<P;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        
        for(int i=0;i<N;i++){
            for(Integer nbr : adj.get(i)){
                Indeg[nbr]++;
            }
        }
        
        for(int i=0;i<Indeg.length;i++){
            if(Indeg[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(Integer nbr : adj.get(curr)){
                Indeg[nbr]--;
                if(Indeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        if(ans.size() == N){
            return true;
        }else{
            return false;
        }
    }
    
}