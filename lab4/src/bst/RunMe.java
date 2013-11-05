package bst;

public class RunMe {
	public static void main(String[] args) {
		BSTVisualizer bst = new BSTVisualizer("Hello", 1000, 780);
		
		BinarySearchTree<Integer> asd = new BinarySearchTree<Integer>();
		
		for(int i = 1; i <= 25; i++) {
			asd.add(i);
		}
		
		//asd.printTree();
		
		asd.rebuild();
		
		//asd.printTree();
		bst.drawTree(asd);
		
		System.out.println("Height: " + asd.height());
		System.out.println("Size: " + asd.size());
	}
}
