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
			if (current.right == null) {
				current = getRightParent(current, result);
			} else {
				current = current.right;
				moveToMinNode();
			}
			return result;
		}
		
		private Node<T> getRightParent(Node<T> node, T result) {
			Node<T> parent = node.parent;
			while (parent != null && comp.compare(parent.obj, result) < 1) {
				parent = parent.parent;
			}
			
			return parent;
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
		Node<T> previous = current.parent;
		int compareResult = Integer.MIN_VALUE;
		while (current != null) {
			previous = current;
			compareResult = comp.compare(current.obj, element);
			if (compareResult == 0) {
				return false;
			} else if (compareResult < 0) {
				current = current.right;
			} else { //compareResult > 0
				current = current.left;
			}
		}
		
		//add new node
		Node<T> newNode = new Node<T>(element);
		newNode.parent = previous;
		if (compareResult < 0) {
			previous.right = newNode;
		} else { //compareResult > 0
			previous.left = newNode;
		}
		
		size++;

		return true;
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
		//TODO
		boolean result = false;
		int compareResult = comp.compare(current.obj, pattern);
		if (compareResult == 0) {
			result = true;
			//todo remove element, need rebalance tree;
			if (isLeaf(current)) {
				removeNode(current);
			} 
			
			else {
				removeNode(current);
//				current.parent.obj = current.left || current.right;
			}
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
	
	private void removeNode(Node<T> current) {
		if (isLeft(current)) {
			current.parent.left = null;
		} else {
			current.parent.right = null;
		}
	}

	private boolean isLeft(Node<T> current) {
		return comp.compare(current.obj, current.parent.obj) < 0;
	}

	private boolean isLeaf(Node<T> current) {
		return current.left == null && current.right == null;
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
		while (current != null && result == false) {
			int compareResult = comp.compare(current.obj, pattern);
			if (compareResult == 0) {
				result = true;
			} else if (compareResult < 0) {
				current = current.right;
			} else { //compareResult > 0
				current = current.left;
			}
		}
		
		return result;
	}

	@Override
	public Iterator<T> iterator() {

		return new TreeSetIterator();
	}

}