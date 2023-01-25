package telran.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class TreeSet<T> extends AbstractCollection<T> implements Sorted<T> {
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
		boolean flNext = false;
		T prev = null;

		TreeSetIterator() {
			if (current != null) {
				current = getLeastNode(current);
			}
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
			T res = current.obj;
			current = getNextCurrent(current);
			flNext = true;
			prev = res;
			return res;
		}

		@Override
		public void remove() {
			if (!flNext) {
				throw new IllegalStateException();
			}

			if (prev != null) {
				TreeSet.this.remove(prev);
			}

			flNext = false;
		}

	}

	private static final String SYMBOL = " ";
	private static final int NUMBER_SYMBOLS_PER_LEVEL = 3;
	private Node<T> root;
	private Comparator<T> comp;

	public TreeSet(Comparator<T> comp) {
		this.comp = comp;
	}

	private Node<T> getNextCurrent(Node<T> current) {

		return current.right == null ? getGreaterParent(current) : getLeastNode(current.right);
	}

	private Node<T> getGreaterParent(Node<T> current) {
		while (current.parent != null && current.parent.left != current) {
			current = current.parent;
		}
		return current.parent;
	}

	private Node<T> getLeastNode(Node<T> current) {
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	private Node<T> getMaxNode(Node<T> current) {
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	@SuppressWarnings("unchecked")
	public TreeSet() {
		this((Comparator<T>) Comparator.naturalOrder());
	}

	@Override
	public boolean add(T element) {
		boolean res = false;
		Node<T> parent = getNode(element);
		int compRes = 0;
		if (parent == null || (compRes = comp.compare(element, parent.obj)) != 0) {
			res = true;
			size++;
			Node<T> node = new Node<>(element);
			node.parent = parent;
			if (parent == null) {
				root = node;
			} else {
				if (compRes < 0) {
					parent.left = node;
				} else {
					parent.right = node;
				}
			}
		}

		return res;
	}

	private Node<T> getNode(T element) {
		Node<T> current = root;
		Node<T> parent = null;
		int compRes;
		while (current != null && (compRes = comp.compare(element, current.obj)) != 0) {
			parent = current;
			current = compRes < 0 ? current.left : current.right;
		}
		return current == null ? parent : current;
	}

	@Override
	public boolean remove(T pattern) {
		boolean result = false;
		Node<T> node = getNode(pattern);

		if (node != null && comp.compare(pattern, node.obj) == 0) {
			if (node.left != null && node.right != null) {
				// do magic
				Node<T> leastNode = getMaxNode(node.left);
				node.obj = leastNode.obj;
				removeNodeWithOneChild(leastNode);
			} else {
				removeNodeWithOneChild(node);
			}
			result = true;
		}

		return result;
	}

	private void removeNodeWithOneChild(Node<T> current) {
		Node<T> child = getChildNode(current);
		if (child != null) {
			child.parent = current.parent;
		}
		if (current.parent == null) {
			if (size == 1) {
				root = null;
			} else {
				root = child;
			}
		} else {
			if (isLeft(current)) {
				current.parent.left = child;
			} else {
				current.parent.right = child;
			}
		}
		current.parent = null;
		current.left = null;
		current.right = null;
		size--;
	}

	private Node<T> getChildNode(Node<T> current) {
		return current.left != null ? current.left : current.right;
	}

	private boolean isLeft(Node<T> current) {
		return comp.compare(current.obj, current.parent.obj) <= 0;
	}

	@Override
	public boolean contains(T pattern) {
		Node<T> node = getNode(pattern);
		return node != null && comp.compare(pattern, node.obj) == 0;
	}

	@Override
	public Iterator<T> iterator() {

		return new TreeSetIterator();
	}

	@Override
	public T floor(T element) {
		Iterator<T> it = iterator();
		T prev = null;
		while (it.hasNext()) {
			T current = it.next();
			if (comp.compare(element, current) < 0) {
				return prev;
			}
			prev = current;
		}

		return prev;
	}

	@Override
	public T ceiling(T element) {
		Iterator<T> it = iterator();
		T result = null;
		while (it.hasNext() && result == null) {
			T current = it.next();
			if (comp.compare(element, current) <= 0) {
				result = current;
			}
		}

		return result;
	}

	@Override
	public T first() {
		T result = null;
		if (root != null) {
			result = getLeastNode(root).obj;
		}

		return result;
	}

	@Override
	public T last() {
		T result = null;
		if (root != null) {
			result = getMaxNode(root).obj;
		}

		return result;
	}

	public void displayTreeRotated() {
		displayTreeRotated(root, 0);
	}

	private void displayTreeRotated(Node<T> root, int level) {
		if (root != null) {
			displayTreeRotated(root.right, level + 1);
			displayRoot(root, level);
			displayTreeRotated(root.left, level + 1);
		}

	}

	private void displayRoot(Node<T> root, int level) {
		System.out.printf("%s%s\n", SYMBOL.repeat(NUMBER_SYMBOLS_PER_LEVEL * level), root.obj);

	}

	public int height() {

		return height(root);
	}

	private int height(Node<T> root) {
		int res = 0;
		if (root != null) {
			int heightLeft = height(root.left);
			int heightRight = height(root.right);
			res = Math.max(heightLeft, heightRight) + 1;
		}

		return res;
	}

	public int width() {
		return width(root);
	}
	
	public int width(Node<T> root) {
		int res = 0;
		if (root != null) {
			if (isLeaf(root)) {
				res++;
			} else {
				int widthLeft = width(root.left);
				int widthRight = width(root.right);
				res = widthLeft + widthRight;
			}
		}
		return res;
	}

	private boolean isLeaf(Node<T> node) {
		return node.left == node.right; //== null
	}

	public void inversion() {
		// TODO Auto-generated method stub

	}

}