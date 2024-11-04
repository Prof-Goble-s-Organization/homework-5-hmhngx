package hw5;

/**
 * Interface to be implemented by PriorityQueues. The order of the items in the 
 * priority queue is determined by the Key's implementation of the Comparator 
 * interface. The key that comes later in the ordering imposed by the compareTo 
 * method appeats at the head of the priority queue.
 * 
 * For example, if Integers or Doubles are used as the key, then larger keys 
 * will be at the head of the queue. Note that for the same reason, if Strings 
 * are used as keys, then words that come later in the dictionary will be at the
 * head of the queue.
 * 
 * @author William Goble
 * @author Dickinson College
 */
public interface COMP232PriorityQueue<K extends Comparable<K>, V>{
	/**
	 * Add the provided key, value pair to the priority queue
	 * 
	 * @param key
	 *      The key
	 * @param value
	 *      The value
	 */
	public void add(K key, V value);

	/**
	 * Remove the <key, value> pair with the highest priority
	 * 
	 * @return
	 *      The value associated with the highest priority key or null if the 
	 *      priority queue is empty
	 */
	public V remove();

	/**
	 * Return a reference to the value at the head of the priority queue without 
	 * remove it from the Queue.
	 * 
	 * @return
	 *      A reference to the element at the head of the priority queue or null 
	 *      if the priority queue is empty.
	 */
	public V peek();

	/**
	 * Return the number of elements in the priority queue.
	 * 
	 * @return
	 *      The size of the priority queue
	 */
	public int size();
}
