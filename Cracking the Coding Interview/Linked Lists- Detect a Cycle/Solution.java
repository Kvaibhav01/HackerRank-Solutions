boolean hasCycle (Node head) {

    if(head == null)
    {
        return false;
    }

    Set<Node> visited = new HasSet<Node>();
    visited.add(head);
    
    Node next = head.next;

    while (next!= null)
    {
    	if (visited.contains(next)) {

    		return true;
    		
    	}

    	visited.add(next);
    	next = next.next;	
    }

    return false;
}
