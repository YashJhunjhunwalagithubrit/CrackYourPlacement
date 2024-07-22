class SmallestPositiveMissing
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
         Arrays.sort(arr);
        int ans=1;
        for(int i=0;i<size;i++){
            if(arr[i]>0){
                if(arr[i]>ans){
                    return ans;
                }
                else  if(arr[i]==ans){
                    ans++;
                }
                else if(arr[i]<ans){
                    continue;
                }
            }
        }
        return ans;
    }
}