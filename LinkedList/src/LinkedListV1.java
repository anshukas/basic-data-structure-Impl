/**
 * https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 * Creation and Insertion in linked list.
 * @author anshukas
 */
public class LinkedListV1 {
	Node head;
	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	public static void main(String[] args) {
		LinkedListV1 list = new LinkedListV1();
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);
		// print list.
		printList(list);
	}
	public static LinkedListV1 insert(LinkedListV1 list, int data) {
		Node new_node = new Node(data);
		new_node.next = null;
		if (list.head == null) {
			list.head = new_node;
		} else {
			// traverse till the last node
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
	public static void printList(LinkedListV1 list) {
		Node currNode = list.head;
		System.out.print("LinkedList: ");
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			// Go to next node
			currNode = currNode.next;
		}
	}
}
