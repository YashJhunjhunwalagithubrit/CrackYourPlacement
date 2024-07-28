class PredecessorandSuccessor {
    static Node floor  = null;
    static Node ceil = null;
    // Find the largest number that is smaller than key
    // ie. the floor
    public static void findfloor(Node root, int key){
        if(root == null) return;
        if(root.data < key){
            floor = root;
            findfloor(root.right, key);
        }
        else if(key <= root.data){
            findfloor(root.left, key);
        }
    }
    
   
    // Find the smallest number that is greater than key.
    // i.e finding the ceil of the key.
    public static void findceil(Node root, int key){
        if(root == null) return;
        if(root.data <= key){
            findceil(root.right, key);
        }
        else if(key < root.data){
            ceil = root;
            findceil(root.left, key);
        }
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        floor  = null;
        ceil = null;
        
        findfloor(root, key);
        findceil(root, key);
        pre[0] = floor;
        suc[0] = ceil;
    }
}