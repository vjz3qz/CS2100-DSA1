//name: Varun Pasupuleti
//computing ID: vjz3qz
//homework name: mod 5a - LLStacksQueue
package queue;

/* You SHOULD use your custom built linked list for this */
import list.LinkedList;

/**
 * A Linked-List based Queue
 *
 * @param <T>
 */
public class Queue<T> implements IQueue<T>{

	private LinkedList<T> list;
	
	/**
	 * Constructor: Initialize the inner list
	 */
	public Queue(){
		/* TODO: Implement this method */
		list=new LinkedList<T>();
	}
	
	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() { 
		/* TODO: Implement this method */
		return list.size();
	}
	
	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		/* TODO: Implement this method */  
		/* Hint: Which method in LinkedList.java already accomplishes this? */ 
		list.insertAtTail(data);
	}
	
	/**
	 * Simply remove data from the head of the list, throw exception if list is empty.
	 */
	public T dequeue(){		
		/* TODO: Implement this method */  
		/* Hint: Which method in LinkedList.java already accomplishes this? */  
		return list.removeAtHead();
	}
	
}
