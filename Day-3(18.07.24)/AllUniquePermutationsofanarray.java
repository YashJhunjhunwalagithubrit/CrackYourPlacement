class AllUniquePermutationsofanarray {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        boolean[] visit=new boolean[n];
        Set<ArrayList<Integer>> hst=new HashSet();
        ArrayList<Integer> curr=new ArrayList();
        Collections.sort(arr);
        chec(arr,visit,hst,res,curr);
        return res;
    }
    static void chec(ArrayList<Integer> arr,boolean[] visit,Set<ArrayList<Integer>> hst,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> curr){
        if(curr.size()==arr.size()){
            if(!hst.contains(curr)){
                hst.add(new ArrayList(curr));
                res.add(new ArrayList(curr));
            }
            return;
        }
        for(int i=0;i<arr.size();i++){
            if(visit[i]==true){
                continue;
            }
            visit[i]=true;
            curr.add(arr.get(i));
            chec(arr,visit,hst,res,curr);
            visit[i]=false;
            curr.remove(curr.size()-1);
        }
    }
};