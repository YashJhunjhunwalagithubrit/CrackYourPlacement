class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> elementQueue = new LinkedList<>();
        elementQueue.add(root);
        int numberOfLevels = 0;

        while (true) {
            int nodeCountAtLevel = elementQueue.size();
            if (nodeCountAtLevel == 0) {
                return numberOfLevels;
            }

            while (nodeCountAtLevel > 0) {
                TreeNode element = elementQueue.poll();
                if (element.left != null) {
                    elementQueue.add(element.left);
                }
                if (element.right != null) {
                    elementQueue.add(element.right);
                }
                nodeCountAtLevel--;
            }

            numberOfLevels++;
        }
    }
}