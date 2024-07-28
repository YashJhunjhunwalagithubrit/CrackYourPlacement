class MinimumAbsoluteDifferenceinBST {
    int minDifference=Integer.MAX_VALUE;
        Integer prev=null;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return minDifference;
        getMinimumDifference(root.left);
        if(prev!=null){
        minDifference=Math.min(minDifference,root.val-prev);
        }
        if(root!=null){
        prev=root.val;
        }
        getMinimumDifference(root.right);
        return minDifference;


    }
}