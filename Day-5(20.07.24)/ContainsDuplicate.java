class ContainDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> inSet=new HashSet<Integer>();
        for(int num:nums){
            if(inSet.contains(num))
                return true;
                inSet.add(num);
            }
            return false;
    }
}