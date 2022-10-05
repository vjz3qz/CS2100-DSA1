//name: Varun Pasupuleti
//computing ID: vjz3qz
//homework name: mod 5a - LLStacksQueue

package list;

public class ListIterator<T> {
	
	/* Current node (of type ListNode) */
	protected ListNode<T> curNode; 
	
/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		/* TODO: Implement this method */
		curNode=currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy tail node? */
		//if(curNode.getData()==null&&curNode.next.getData()==null)
		if(curNode.next!=null)
			return false;
		return true;
	}
	
	public boolean isPastBeginning() { 
		/* TODO: Implement this method */
		/* Hint: How do you know if you’re at the dummy head node? */
		//if(curNode.getData()==null&&curNode.prev.getData()==null)
		if(curNode.prev!=null)
			return false;
		return true;
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		/* TODO: Implement this method */
		/* Hint: Remember to first validate the position of the Iterator */
		if(!isPastEnd()&&!isPastBeginning())
			return curNode.getData();
		return null;
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move forward before you do! */
		/*       (Otherwise, do not move at all) */
		if(!isPastEnd())
			curNode=curNode.next;
	}
	
	public void moveBackward() { 
		/* TODO: Implement this method */
		/* Hint: Remember to check IF you can move backwards before you do! */
		/*       (Otherwise, do not move at all) */
		if(!isPastBeginning())
			curNode=curNode.prev;
	}
}


