package telran.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSet<T> extends AbstractCollection<T> implements Set<T> {
	static private class Node<T> {
		T obj;
		Node<T> parent;
		Node<T> left;
		Node<T> right;

		Node(T obj) {
			this.obj = obj;
		}
	}

	private class TreeSetIterator implements Iterator<T> {
		Node<T> current = root;
//TODO
		/**'
		 * Iterating in ascending order
Finding the least element (from root to left until left is null)
Algorithm of next
If right reference is null, looking for first parent from right (current = current.parent)
If right reference id not null, looking for the least element from the right subtree
hasNext - current != null

		 */
		public TreeSetIterator() {
			moveToMinNode();
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T result = current.obj;
			
/*
 * If right reference is null, looking for first parent from right (current = current.parent)
If right reference id not null, looking for the least element from the right subtree
 */
			if (current.right == null) {
				Node<T> parent = current.parent;
				if (comp.compare(parent.obj, result) > 0) {
					current = parent;
				} else {
					current = null;
				}
				
			} else {
				current = current.right;
				moveToMinNode();
			}
			return result;
		}
		
		private void moveToMinNode() {
			while (current.left != null) {
				current = current.left;
			}
		}
	}

	private Node<T> root;
	private Comparator<T> comp;

	public TreeSet(Comparator<T> comp) {
		this.comp = comp;
	}

	@SuppressWarnings("unchecked")
	public TreeSet() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	@Override
	public boolean add(T element) {
		boolean result = false;
		if (root == null) {
			root = new Node<T>(element);
			size++;
			result = true;
		} else {
			result = addNode(root, element);
		}

		return result;
	}
	
	private boolean addNode(Node<T> current, T element) {
		boolean result = true;
		int compareResult = comp.compare(current.obj, element);
		if (compareResult == 0) {
			result = false;
		} else if (compareResult < 0) {
			if (current.right != null) {
				result = addNode(current.right, element);
			} else {
				//add new node
				Node<T> newNode = new Node<T>(element);
				newNode.parent = current;
				current.right = newNode;
				size++;
			}
		} else { //compareResult > 0
			if (current.left != null) {
				result = addNode(current.left, element);
			} else {
				//add new node
				Node<T> newNode = new Node<T>(element);
				newNode.parent = current;
				current.left = newNode;
				size++;
			}
		}
		return result;
	}

	@Override
	public boolean remove(T pattern) {
		boolean result = false;
		if (root == null) {
			result = false;
		} else {
			result = remove(root, pattern);
		}

		return result;
	}
	
	private boolean remove(Node<T> current, T pattern) {
		boolean result = false;
		int compareResult = comp.compare(current.obj, pattern);
		if (compareResult == 0) {
			result = true;
			//todo remove element, need rebalance tree;
		} else if (compareResult < 0) {
			if (current.right != null) {
				result = remove(current.right, pattern);
			}
		} else { // compareResult > 0
			if (current.left != null) {
				result = remove(current.left, pattern);
			}
		}
		return result;
	}

	@Override
	public boolean contains(T pattern) {
		boolean result = false;
		if (root == null) {
			result = false;
		} else {
			result = contains(root, pattern);
		}

		return result;
	}
	
	private boolean contains(Node<T> current, T pattern) {
		boolean result = false;
		int compareResult = comp.compare(current.obj, pattern);
		if (compareResult == 0) {
			result = true;
		} else if (compareResult < 0) {
			if (current.right != null) {
				result = contains(current.right, pattern);
			}
		} else { // compareResult > 0
			if (current.left != null) {
				result = contains(current.left, pattern);
			}
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {

		return new TreeSetIterator();
	}

}