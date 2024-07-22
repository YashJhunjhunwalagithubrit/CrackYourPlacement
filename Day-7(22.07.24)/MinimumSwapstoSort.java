
class MinimumSwapstoSort
{
    //Function to find the minimum number of swaps required to sort the array.
    public void swap(int arr[],int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public int minSwaps(int nums[])
    {
        // Code here
        Map<Integer,Integer> map=new HashMap<>();
        int[] numsSorted=nums.clone();
        Arrays.sort(numsSorted);
        for(int i=0;i<numsSorted.length;i++){
            map.put(numsSorted[i],i);
        }
        int swap=0;
        int i=0;
        while(i<nums.length){
            if(map.get(nums[i])==i){
                i++;
            }else{
                swap(nums,i,map.get(nums[i]));
                swap++;
            }
        }
        return swap;
    }
}