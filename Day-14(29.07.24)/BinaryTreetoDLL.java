class BinaryTreetoDLL
{
    void dll(Node root,Node []arr){
        if(root==null)
        return ;
        dll(root.left,arr);
        if(arr[1]==null){
            arr[1]=root;
            arr[0]=root;
        }
        else {
            root.left=arr[0];
            arr[0].right=root;
            arr[0]=root;
        }
        dll(root.right,arr);
    } 
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	 Node []arr={null,null};
	 dll(root,arr);
	 return arr[1];
    }
}