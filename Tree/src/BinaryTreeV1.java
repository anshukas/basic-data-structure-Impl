import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *     (10)
 *     /  \
 *   (20) (30)
 *   /  \
 * (40)  (50)
 * 
 * pre-order: 	10 20 40 50 30
 * in-order: 	40 20 50 10 30 
 * post-order:	40 50 20 30 10 
 * 
 * @author ak185398
 *
 */
public class BinaryTreeV1 {
	private Node root;

	private class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public void createBinaryTree() {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		Node fifth = new Node(50);

		root = first;
		first.left = second;
		first.right = third; // second <--- first ---> third

		second.left = fourth;
		second.right = fifth;
	}

	public void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void iterativePreOrder() {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

	public void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void iterativeInOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> stack = new Stack<Node>();
		Node temp = root;

		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}

	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public void levelOrder(Node root) {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeV1 tree = new BinaryTreeV1();

		tree.createBinaryTree();

		System.out.println("Pre Order: ");
		// tree.preOrder(tree.root);
		tree.iterativePreOrder();

		System.out.println("\nIn Order: ");
		tree.inOrder(tree.root);

		System.out.println("\nIterative In Order: ");
		tree.iterativeInOrder(tree.root);

		System.out.println("\nPost Order:");
		tree.postOrder(tree.root);

		System.out.println("\nLevel Order: ");
		tree.levelOrder(tree.root);
	}
}
