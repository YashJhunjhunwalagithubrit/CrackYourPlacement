class Permutationsinarray {
    public boolean isPossible(long a[], long b[], int n, long k) {
        // Your code goes here
         long c[]=new long[n];
        Arrays.sort(a);
        Arrays.sort(b);
        //int j=0;
        for(int i=0;i<n;i++){
            c[n-i-1]=b[i];
            //j++;
        }
        for(int i=0;i<n;i++){
            if(a[i]+c[i]>=k){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}