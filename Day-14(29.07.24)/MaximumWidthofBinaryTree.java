class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        Map<TreeNode,Integer> map=new HashMap<>();
        map.put(root,0);
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            int left=map.get(qu.peek());
            while(size-->0){
                TreeNode head=qu.poll();
                maxWidth=Math.max(maxWidth,map.get(head)-left+1);
                if(head.left!=null){
                    qu.offer(head.left);
                    map.put(head.left,2*map.get(head));
                }
                if(head.right!=null){
                    qu.offer(head.right);
                    map.put(head.right,2*map.get(head)+1);
                }
            }
        }
        return maxWidth;
    }
}