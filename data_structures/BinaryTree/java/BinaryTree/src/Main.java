
public class Main {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.addNode(50, "Boss");
		tree.addNode(25, "VP");
		tree.addNode(15, "Office Manager");
		tree.addNode(30, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(85, "Salesman1");
		System.out.println("== current employees (InOrder) ==");
		tree.inOrder(tree.root);
		
		System.out.println("== current employees (BFS) ==");
		tree.levelOrderQueue(tree.root);
		
		System.out.println("== current employees (after getting ride of Boss) ==");
		tree.delNode(50);
		tree.inOrder(tree.root);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}