/**
 * https://www.youtube.com/watch?v=-j6LVWmyCCU&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=2
 * Create a linked list in java.
 * 
 * @author ak185398
 *
 */
public class LinkedListV0 {
	private Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static void main(String[] args){
		// 10 -> 20 -> 30 -> 40 -> null
		Node head = new Node(10);
		Node second  = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);
		
		// attached nodes.
		head.next = second;  // 10 -> 20
		second.next = third; // 10 -> 20 -> 30
		third.next = fourth;
	}
	
	
}
