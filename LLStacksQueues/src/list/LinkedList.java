//name: Varun Pasupuleti
//computing ID: vjz3qz
//homework name: mod 5a - LLStacksQueue
package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements List<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		/* TODO: Implement this method */  
		head=new ListNode<T>(null);
		tail=new ListNode<T>(null);
		head.next=tail;
		tail.prev=head;
		size=0;
	}
	
	public int size() {
		/* TODO: Implement this method */  
		int count=0;
		//creates a list iterator
		ListIterator<T> node=new ListIterator<T>(head.next);
		//while not at tail
		while(!node.isPastEnd())
		{
			node.moveForward();
			//iterate
			count++;
		}
		return count;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		/* TODO: Implement this method */  
		//creates new null head and tail and set size to 0
		head.next=tail;
		tail.prev=head;
		size=0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		/* TODO: Implement this method */
		//create a new node for given data
		ListNode<T> newNode=new ListNode<T>(data);
		newNode.next=tail;
		newNode.prev=tail.prev;
		tail.prev.next=newNode;
		tail.prev=newNode;
		size++;
	}
	
	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		/* TODO: Implement this method */
		ListNode<T> newNode=new ListNode<T>(data);
		newNode.prev=head;
		newNode.next=head.next;
		head.next.prev=newNode;
		head.next=newNode;
		size++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		/* TODO: Implement this method */
		//index check
		if(index>=0 && index<=size)
		{
			ListIterator<T> node=front();
			//iterates to node at index
			for(int i=0;i<index;i++)
				node.moveForward();
			ListNode<T> newNode=new ListNode<T>(data);
			//inserts before the node that was iterated to
			newNode.next=node.curNode;
			newNode.prev=node.curNode.prev;
			node.curNode.prev.next=newNode;
			node.curNode.prev=newNode;
			size++;
		}
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		/* TODO: Implement this method */  
		ListNode<T> newNode=new ListNode<T>(data);
		newNode.prev=it.curNode;
		newNode.next=it.curNode.next;
		it.curNode.next.prev=newNode;
		it.curNode.next=newNode;
		size++;
	}
	
	
	
	public T removeAtTail(){
		/* TODO: Implement this method */  
		//checks if there is a node there
		if(size!=0)
		{
			//saves the node
			ListNode<T> remNode=tail.prev;
			//sets the pointers before and after it to each other
			remNode.prev.next=tail;
			tail.prev=remNode.prev;
			size--;
			//return it
			return remNode.getData();
		}
		return null;
	}
	
	public T removeAtHead(){
		/* TODO: Implement this method */
		//checks if there is a node there
		if(size!=0)
		{
			//saves the node
			ListNode<T> remNode=head.next;
			//sets pointers around it to each other
			remNode.next.prev=head;
			head.next=remNode.next;
			size--;
			//return it
			return remNode.getData();
		}
		return null;
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		/* TODO: Implement this method */
		it.curNode.prev.next=it.curNode.next;
		it.curNode.next.prev=it.curNode.prev;
		return it.value();
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		/* TODO: Implement this method */
		ListIterator<T> node=front();
		for(int i=0;i<size;i++)
		{
			if(data.equals(node.value()))
				return i;
			node.moveForward();
		}
		return -1;
	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) { 
		/* TODO: Implement this method */  
		//index check
		if(index>=0 && index<size)
		{
			ListIterator<T> node=front();
			for(int i=0;i<index;i++)
				node.moveForward();
			return node.value();
		}
		return null;
	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){ 
		/* TODO: Implement this method */  
		//creates new list iterator
		ListIterator<T> node=new ListIterator<T>(head.next);
		return node;
	}

	public ListIterator<T> back(){
		/* TODO: Implement this method */ 
		//creates new list iterator
		ListIterator<T> node=new ListIterator<T>(tail.prev);
		return node;
	}
	
	
}
