class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList();
        dfs(res,root);
        return res;
    }
    void dfs(List<Integer> res,TreeNode root){
        if(root!=null){
            if(root.left!=null){
                dfs(res,root.left);
            }
            res.add(root.val);
            if(root.right!=null){
                dfs(res,root.right);
            }
        }
    }
}