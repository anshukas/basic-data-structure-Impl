import java.util.NoSuchElementException;

public class QueueV1 {
	private Node front;
	private Node rear;
	private int length;

	public QueueV1() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	private class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public int length() {
		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public void enqueue(int data) {
		Node temp = new Node(data);

		if (isEmpty()) {
			front = temp;
		} else {
			rear.next = temp;
		}
		rear = temp;
		length++;
	}

	public void print() {
		if (isEmpty()) {
			return;
		}
		Node current = front;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public int dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is already empty.");
		}

		int result = front.data;
		front = front.next;

		if (front == null)
			rear = null;

		length--;
		return result;
	}

	public static void main(String[] args) {
		QueueV1 queue = new QueueV1();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.print();

		queue.dequeue();
		queue.print();
	}
}
