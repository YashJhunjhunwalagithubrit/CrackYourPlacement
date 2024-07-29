class RecoverBinarySearchTree {
    private TreeNode prev=null;
    private TreeNode one=null;
    private TreeNode two=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=one.val;
        one.val=two.val;
        two.val=temp;
    }
    private void inorder(TreeNode curr){
        if(curr==null)
        return;
        inorder(curr.left);
        if(prev!=null && prev.val>curr.val){
            if(one==null){
                one =prev;
            }
            two=curr;
        }
        prev=curr;
        inorder(curr.right);
    }
}