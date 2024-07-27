class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int nums[],int start,int end){
        if(start>end){
            return null;
        }
        int mid=(end+start)/2;
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left=helper(nums,start,mid-1);
        newNode.right=helper(nums,mid+1,end);
        return newNode;
    }
}