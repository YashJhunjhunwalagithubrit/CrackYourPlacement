class RangeSumQuery {
    int num[];
    public NumArray(int[] nums) {
       for(int i = 1;i<nums.length;i++)
        {
            nums[i]+=nums[i-1];
        }
        this.num= nums; 
    }
    
    public int sumRange(int left, int right) {
        if(left == 0)
            return num[right];
        else 
            return num[right]-num[left-1];
    }
}
