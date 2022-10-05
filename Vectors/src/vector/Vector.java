 package vector;

import java.util.Arrays;

public class Vector<T> implements List<T> {

	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	public int capacity() {
		return this.itemArray.length;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {
		// TODO: Implement this method
		//if the new capacity is smaller, don't do anything
		if(size()>newCapacity)
			return;
		//create a new array with the given new capacity
		T[] newArr=(T[]) new Object[newCapacity];
		//iterates through array and copies to new array
		for(int i=0;i<size();i++)
			newArr[i]=itemArray[i];
		//sets our array to the new array
		this.itemArray=newArr;
	}

	@Override
	public int size() {
		// TODO: Implement this method
		return this.size;
//		int i=0;
//		while(itemArray[i]!=null)
//			i++;
//		return i;
			
	}

	@Override
	public void clear() {
		// TODO: Implement this method
		//creates a new empty array with same capacity
		T[] newArr=(T[]) new Object[capacity()];
		//sets to our array
		this.itemArray=newArr;
		//sets size to 0
		size=0;
	}

	@Override
	public void insertAtTail(T item) {
		// TODO: Implement this method
		//checks if array is filled, if so doubles
		if(size()==capacity())
			resize(size()*2);
		//puts item at tail
		itemArray[size()]=item;
		//iterate size
		size++;
	}

	@Override
	public void insertAtHead(T item) {
		// TODO: Implement this method
		//checks if array is filled, if so doubles
		if(size()==capacity())
			resize(size()*2);
		//shifts all elements up one in the array
		//uses minus one for index
		for(int i=size()-1;i>=0;i--)
			itemArray[i+1]=itemArray[i];
		//adds item at the head
		itemArray[0]=item;
		//iterate size
		size++;
	}

	@Override
	public void insertAt(int index, T item) {
		// TODO: Implement this method
		//checks if array is filled, if so doubles
		if(size()==capacity())
			resize(size()*2);
		//shifts all elements up one in the array
		//uses minus one for index
		for(int i=size()-1;i>=index;i--)
			itemArray[i+1]=itemArray[i];
		//adds item at the head
		itemArray[index]=item;
		//iterate size
		size++;
	}

	@Override
	public T removeAtTail() {
		// TODO: Implement this method
		//don't actually need to deallocate memory for removal at tail
		//decrements size after removing
		size--;
		return itemArray[size()+1];
	}

	@Override
	public T removeAtHead() {
		// TODO: Implement this method
		//save removed item
		T removed=itemArray[0];
		//DO YOU DO SIZE OR SIZE-1 HERE
		//i think size-1 so you don't get out of bound error, 
		//no need to deallocate memory for last, can just decrement size
		//pushes all elements down one
		for(int i=0;i<size()-1;i++)
			itemArray[i]=itemArray[i+1];
		//decrements size
		size--;
		return removed;
	}

	@Override
	public int find(T item) {
		// TODO: Implement this method
		//iterates through array checking if any item equals desired
		for(int i=0;i<size();i++)
			if(itemArray[i].equals(item))
				//returns index if found
				return i;
		return -1;//returns sentinel value otherwise
	}

	@Override
	public T get(int index) {
		// TODO: Implement this method
		if(index>=0 && index<size())//checks if index is valid
			return itemArray[index];//returns item
		return null;//if not valid return null
	}

	/*
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}
