class ConstructBinaryTreefromPreorderandPostorderTraversal {
    int postpreindex=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return helper(preorder,postorder,map,0,postorder.length-1);
    }
    private TreeNode helper(int[] pre,int[] post,HashMap<Integer,Integer> map,int start,int end){
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(pre[postpreindex++]);
        if(start==end){
            return root;
        }
        int index=map.get(pre[postpreindex]);
        root.left=helper(pre,post,map,start,index);
        root.right=helper(pre,post,map,index+1,end-1);
        return root;
    }
}