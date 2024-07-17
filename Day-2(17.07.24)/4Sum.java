class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
        ArrayList<Integer>list=new  ArrayList<>();
        List<List<Integer>>list2=new  ArrayList<>();
        HashSet<List<Integer>>mpp=new HashSet<>();
        int i=0;
        int j=1;int k=2;int l=nums.length-1;
        while(i<j &&k<l){
        while(j<k &&k<l){   
           while(k<l){
            long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
            if(sum==target)
            {
                 Collections.addAll(list,nums[i],nums[j],nums[k],nums[l]);
                 mpp.add(list);
                 list=new  ArrayList<>();
                k++;l--;
            }
            else if(sum>target)
            l--;
            else if(sum<target)
            k++;
           }
          j++;
          k=j+1;l=nums.length-1;
        }
           i++;
           j=i+1;k=j+1;l=nums.length-1;  
        }
        
        for(List<Integer> ii:mpp){
            list2.add(ii);
        }
        
        return list2;  
    }
}