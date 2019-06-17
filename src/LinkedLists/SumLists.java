package LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class SumLists {

	public static void main(String[] args) {

		Node<Integer> list1 = new Node<>(7);
		list1.next = new Node<>(1);
		list1.next.next = new Node<>(6);

		Node<Integer> list2 = new Node<>(5);
		list2.next = new Node<>(9);
		list2.next.next = new Node<>(2);
		
		Node<Integer> node = sumLists(list1, list2);
		
		printNodes(node);

	}

	public static Node<Integer> sumLists(Node<Integer> list1, Node<Integer> list2) {

		int n = getSum(list1) + getSum(list2);

		Node<Integer> summedNode = getSummedNode(n);

		return summedNode;

	}

	private static Node<Integer> getSummedNode(int n) {

		int n2 = n % 10;
		n /= 10;

		Node<Integer> node = new Node<>(n2);

		Node<Integer> current = node;

		while (n != 0) {

			n2 = n % 10;
			n /= 10;
			current.next = new Node<>(n2);
			current = current.next;

		}

		return node;

	}

	public static void printNodes(Node<Integer> node) {

		Node<Integer> current = node;

		while (current != null) {
			System.out.print(current.e + " ");
			current = current.next;
		}
		System.out.println();
	}

	private static int getSum(Node<Integer> list) {

		int n1 = list.e + getNumber(list.next);
		
		System.out.println(n1);

		return n1;
	}

	private static int getNumber(Node<Integer> list) {

		if (list == null)
			return 0;

		return (getNumber(list.next) + list.e) * 10;
	}

}
