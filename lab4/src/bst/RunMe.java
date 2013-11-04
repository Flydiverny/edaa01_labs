package bst;

public class RunMe {
	public static void main(String[] args) {
		BSTVisualizer bst = new BSTVisualizer("Hello", 1000, 780);
		
		BinarySearchTree<Integer> asd = new BinarySearchTree<Integer>();
		
		asd.add(1);
		asd.add(2);
		asd.add(3);
		asd.add(4);
		asd.add(5);
		asd.add(6);
		asd.add(7);
		asd.add(8);
		asd.add(9);
		
		asd.printTree();
		
		asd.rebuild();
		
		asd.printTree();
		bst.drawTree(asd);
		
		System.out.println("Height: " + asd.height());
		System.out.println("Size: " + asd.size());
	}
}
