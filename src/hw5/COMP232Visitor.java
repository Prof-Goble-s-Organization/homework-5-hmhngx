package hw5;

/**
 * Interface to be implemented by Visitors that act on the key, value pairs 
 * stored in nodes in binary trees.
 * 
 * @author William Goble
 * @author Dickinson College
 */
public interface COMP232Visitor<K, V> {
	/**
	 * The visit method will be invoked at each node in the tree. The order in 
	 * which the nodes are visited is determined by the method that is used 
	 * 
	 * @param key
	 *      The key stored in the node
	 * @param value
	 *      The value stored at the node
	 */
	public void visit(K key, V value);
}
