class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> subans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr==null){
                ans.add(subans);
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    subans=new ArrayList<>();
                }
            }else{
                subans.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}