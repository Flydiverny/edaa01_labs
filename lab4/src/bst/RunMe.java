package bst;

public class RunMe {
	public static void main(String[] args) {
		BSTVisualizer bst = new BSTVisualizer("Hello", 1000, 780);
		
		BinarySearchTree<Integer> asd = new BinarySearchTree<Integer>();
		
//		for(int i = 1; i <= 25; i++) {
//			asd.add(i);
//		}
		
		asd.add(3);
		asd.add(4);
		asd.add(5);
		asd.add(6);
		asd.add(0);
		asd.add(7);
		System.out.println("Tree: ");
		asd.printTree();

		System.out.println("\nHeight: " + asd.height());
		System.out.println("Size: " + asd.size());
		
		
		System.out.println("Rebuilding!!1111");
		
		asd.rebuild();
		
		System.out.println("\nTree: ");
		asd.printTree();
		bst.drawTree(asd);
		
		System.out.println("\nHeight: " + asd.height());
		System.out.println("Size: " + asd.size());
	}
}
