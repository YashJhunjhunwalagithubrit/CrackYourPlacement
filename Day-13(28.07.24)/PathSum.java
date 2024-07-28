class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        return false;
        Stack<TreeNode> path=new Stack<>();
        Stack<Integer> sumPath=new Stack<>();
        path.push(root);
        sumPath.push(root.val);
        while(!path.isEmpty()){
            TreeNode temp=path.pop();
            int tempPath=sumPath.pop();
            if(temp.left==null && temp.right==null && tempPath==targetSum)
            return true;
            if(temp.right!=null){
                path.push(temp.right);
                sumPath.push(temp.right.val+tempPath);
            }
            if(temp.left!=null){
                path.push(temp.left);
                sumPath.push(temp.left.val+tempPath);
            }
        }
        return false;
    }
}