import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;
	
	public void levelOrderQueue(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.println(n.toString());
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}

	public boolean delNode(int key) {
		// Start at the top of the tree
				Node focusNode = root;
				Node parent = root;

				// When searching for a Node this will
				// tell us whether to search to the
				// right or left
				boolean isItALeftChild = true;

				// While we haven't found the Node
				// keep looking
				while (focusNode.key != key) {
					parent = focusNode;
					
					// If we should search to the left
					if (key < focusNode.key) {
						isItALeftChild = true;
						// Shift the focus Node to the left child
						focusNode = focusNode.left;
					} else {
						// Greater than focus node so go to the right
						isItALeftChild = false;
						
						// Shift the focus Node to the right child
						focusNode = focusNode.right;
					}

					// The node wasn't found
					if (focusNode == null)
						return false;
				}

				// If Node doesn't have children delete it
				if (focusNode.left == null && focusNode.right == null) {
					// If root delete it
					if (focusNode == root)
						root = null;

					// If it was marked as a left child
					// of the parent delete it in its parent
					else if (isItALeftChild)
						parent.left = null;
					// Vice versa for the right child
					else
						parent.right = null;
				}

				// If no right child
				else if (focusNode.right == null) {
					if (focusNode == root)
						root = focusNode.left;

					// If focus Node was on the left of parent
					// move the focus Nodes left child up to the
					// parent node
					else if (isItALeftChild)
						parent.left = focusNode.left;
					// Vice versa for the right child
					else
						parent.right = focusNode.left;
				}

				// If no left child
				else if (focusNode.left == null) {
					if (focusNode == root)
						root = focusNode.right;
					// If focus Node was on the left of parent
					// move the focus Nodes right child up to the
					// parent node
					else if (isItALeftChild)
						parent.left = focusNode.right;
					// Vice versa for the left child
					else
						parent.right = focusNode.right;
				}
				// Two children so I need to find the deleted nodes
				// replacement
				else {
					Node replacement = getReplacementNode(focusNode);

					// If the focusNode is root replace root
					// with the replacement
					if (focusNode == root)
						root = replacement;
					// If the deleted node was a left child
					// make the replacement the left child
					else if (isItALeftChild)
						parent.left = replacement;
					// Vice versa if it was a right child
					else
						parent.right = replacement;

					replacement.left = focusNode.left;
				}
				return true;
			}

	private Node getReplacementNode(Node toBeReplacedNode) {
		Node replacementParent = toBeReplacedNode;
		Node replacement = toBeReplacedNode;
		Node focusNode = toBeReplacedNode.right;
		
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.left;
		}
		if (replacement != toBeReplacedNode.right) {
			replacementParent.left = replacement.right;
			replacement.right = toBeReplacedNode.right;
		}
		return replacement;
	}
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.left;
					if (focusNode == null) {
						parent.left = newNode;
						return;
					}
				} else {
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	} // addNode
	
	public void inOrder(Node focusNode) {
		if (focusNode != null) {
			inOrder(focusNode.left);
			System.out.println(focusNode.toString());
			inOrder(focusNode.right);
		}
	} // inOrder
	
	public void preOrder(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode.toString());
			preOrder(focusNode.left);
			preOrder(focusNode.right);
		}
	} // preOrder
	
	public void postOrder(Node focusNode) {
		if (focusNode != null) {
			postOrder(focusNode.left);
			postOrder(focusNode.right);
			System.out.println(focusNode.toString());
		}
	} // postOrder
}

class Node {
	int key;
	String name;
	Node left;
	Node right;
	
	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public String toString() {
		return name + " has a key " + key;
	}
}
