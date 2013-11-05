package bst;

import org.junit.runner.notification.StoppedByUserException;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		boolean returnValue = false;
		
		if(root == null) {
			root = new BinaryNode<E>(x);
			returnValue = true;
		} else {
			returnValue = add(root, x);
		}
		
		if(returnValue)
			size++;
		
		return returnValue;
	}
	
	private boolean add(BinaryNode<E> node, E e) {
		int result = node.element.compareTo(e);
		
		if(result == 0) {
			return false;
		}
		
		if(result > 0) {
			if(node.left == null) {
				node.left = new BinaryNode<E>(e);
				return true;
			} 
			
			return add(node.left, e);
		}

		if(node.right == null) {
			node.right = new BinaryNode<E>(e);
			return true;
		}
		
		return add(node.right, e);
	}

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	
	private int height(BinaryNode<E> node) {
		if(node == null) {
			return 0;
		}
		
		int left = height(node.left);
		int right = height(node.right);
		
		return 1 + (left > right ? left : right);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Recursive calculation of size.
	 * @param node
	 * @return
	 */
	private int size(BinaryNode<E> node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + size(node.left) + size(node.right);
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		//System.out.println("Tree: " + printTree(root));
		printTree(root);
	}
	
	private void printTree(BinaryNode<E> node) {
		if(node == null) {
			return;
		}
		
		System.out.print("(");
		printTree(node.left);
		System.out.print(node.element);
		printTree(node.right);
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() { 
		E[] a = (E[]) new Comparable[size()];
		toArray(root, a, 0);
		
		root = buildTree2(a, 0, a.length-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if(n == null) {
			return index;
		}
		
		index = toArray(n.left, a, index);
		a[index++] = n.element;
		
		return toArray(n.right, a, index);
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree2(E[] a, int first, int last) {
		BinaryNode<E> node;
		
		switch(last-first) {
		case 0:
			return new BinaryNode<E>(a[first]);
		case -1:
			node = new BinaryNode<E>(a[first]);
            node.right = new BinaryNode<E>(a[last]);
            return node;
		case 1:
			node = new BinaryNode<E>(a[last]);
            node.left = new BinaryNode<E>(a[first]);
            return node;
        default:
            int mid = (first+last)/2;
        	node = new BinaryNode<E>(a[mid]);
        	node.left = buildTree(a, first, mid-1);
        	node.right = buildTree(a, mid+1, last);
        	return node;
		}
	}
	
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
        if(first == last)
            return new BinaryNode<E>(a[first]);
        
        int mid = (last + first + 1) / 2;

        BinaryNode<E> node = new BinaryNode<E>(a[mid]);
        node.left = buildTree(a, first, mid-1);        

        if(mid != last)
            node.right = buildTree(a, mid+1, last);
    
        return node;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
