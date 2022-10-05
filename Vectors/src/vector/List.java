package vector;

public interface List<T> {
	
	/**
	 * Returns the number of items in this Vector
	 * @return
	 */
	public int size();
	
	/**
	 * Changes the Vector so that it contains zero items
	 */
	public void clear();
	
	/**
	 * Inserts new item at the end of the Vector
	 * @param data
	 */
	public void insertAtTail(T item);
	
	/**
	 * Inserts item at the beginning of the Vector
	 * @param item
	 */
	public void insertAtHead(T item);
	
	/**
	 * Inserts item such that index becomes the position of the newly inserted item
	 * @param item
	 * @param index
	 */
	public void insertAt(int index, T item);
	
	/**
	 * Remove item at start and end of Vector respectively (two separate methods),
	 * returning the item that’s removed
	 * @return
	 */
	public T removeAtTail();
	public T removeAtHead();
	
	
	/**
	 * Returns index of first occurrence of the item in the list, or -1 if not present
	 * @param item
	 * @return
	 */
	public int find(T item);
	
	/**
	 * Returns the item at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index);
	
}
