class ConstructTreefromPreorderTraversal{
     int idx = -1;
    Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	    List <Integer> nodes = new ArrayList<>();
	    
	    for(int i = 0;i<n;i++){
	        nodes.add(pre[i]);
	        if(preLN[i] == 'L'){
	            nodes.add(-1);
	            nodes.add(-1);
	        }
	    }
	    
	    return buildTree(nodes);
	    
    }
    
    // buildTree
    Node buildTree(List <Integer> nodes){
        idx++;
        
        if(idx >= nodes.size()){
            return null;
        }
        if(nodes.get(idx) == -1){
            return null;
        }
        
        Node newNode = new Node(nodes.get(idx));
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        
        return newNode;
    }
}