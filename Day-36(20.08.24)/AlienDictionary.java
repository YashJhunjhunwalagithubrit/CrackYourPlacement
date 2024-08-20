class AlienDictionary
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
         List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<K; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<N-1; i++){
            String first = dict[i];
            String second = dict[i+1];
            int len = Math.min(first.length(),second.length());
            for(int j=0; j<len; j++){
                char f = first.charAt(j);
                char s = second.charAt(j);
                if(f!=s){
                    adj.get(f-'a').add(s-'a');
                    break;
                }
            }
        }
        //topo sort
        int[] indegree = new int[K];
        for(int i = 0; i<K; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<K; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int rem = q.remove();
            topo.add(rem);
            for(int j : adj.get(rem)){
                indegree[j]--;
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }
//creating output string
        String s = "";
        int l = 0;
        if(topo.size()!=K){
            for(char i = 'a'; i<='z'; i++){
                s += i;
                l++;
                if(l==K) break;
            }
        }
        else{
            for(int i = 0; i<topo.size(); i++){
                s += (char)(topo.get(i)+97);
            }
        }
        return s;
        
        
    }
}