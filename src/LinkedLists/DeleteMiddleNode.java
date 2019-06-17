package LinkedLists;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		
		Node<String> node = new Node<>("e1");
		
		node.next = new Node<>("e2");
		node.next.next = new Node<>("e3");
		node.next.next.next = new Node<>("e4");
		node.next.next.next.next = new Node<>("e5");
		node.next.next.next.next.next = new Node<>("e6");
		node.next.next.next.next.next.next = new Node<>("e7");
		node.next.next.next.next.next.next.next = new Node<>("e8");
		
		printNodes(node);
		
		deleteMiddleNode(node);
		
		printNodes(node);
		
	}
	
	
	public static void deleteMiddleNode(Node<String> node) {
		
		Node<String> slow = node;
		Node<String> fast = node;
		Node<String> prev = null;
		
		while(slow.next != null && fast.next.next != null) {
			
			prev = slow;
			
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		prev.next = slow.next;
		slow.next = null;
		
	}
	
	public static void printNodes(Node<String> node) {
		
		Node<String> current = node;
		
		while(current != null) {
			System.out.print(current.e + " ");
			current = current.next;
		}
		System.out.println();
	}
	

}

class Node<E> {
	Node<E> next;
	E e;
	
	public Node(E e) {
		this.e = e;
	}
}
