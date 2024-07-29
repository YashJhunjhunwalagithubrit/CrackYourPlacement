class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);
        boolean leftToRight=true;
        while(!qu.isEmpty()){
            int size=qu.size();
            List<Integer> subList=new ArrayList<>();
            while(size-->0){
                TreeNode head=qu.poll();
                if(leftToRight){
                    subList.add(head.val);
                }else{
                    subList.add(0,head.val);
                }
                if(head.left!=null){
                    qu.offer(head.left);
                }
                if(head.right!=null){
                    qu.offer(head.right);
                }
            }
            ans.add(subList);
            leftToRight=!leftToRight;
        }
        return ans;
    }
}