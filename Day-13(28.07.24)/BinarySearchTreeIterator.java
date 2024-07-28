class BinarySearchTreeIterator {
    Stack<TreeNode> order=new Stack<>();
    public BSTIterator(TreeNode root) {
        partialInOrder(root);
    }
    void partialInOrder(TreeNode node){
        while(node!=null){
            order.push(node);
            node=node.left;
        }
    }
    
    public int next() {
       TreeNode top=order.pop();
       partialInOrder(top.right);
       return top.val; 
    }
    
    public boolean hasNext() {
        return !order.isEmpty();
    }
}
