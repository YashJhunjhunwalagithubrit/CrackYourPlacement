class BinaryTreeRightSideView {
    int maxlevel=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        right(root,list,1);
        return list;
    }
    void  right(TreeNode root,List<Integer> list,int level){
        if(root==null){
            return;
        }
        if(maxlevel<level){
            list.add(root.val);
            maxlevel=level;
        }
        right(root.right,list,level+1);
        right(root.left,list,level+1);
    }
}