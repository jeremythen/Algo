package IntroductionToAlgo3rd;

import java.util.Objects;
import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

public class BinarySearchTree<E extends Comparable<E>> {

	private int size;
	private static TreeNode testNode;
	private static int val = 13;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		BinarySearchTree<Integer> b = getFilledTree();

		TreeNode<Integer> s = b.getSuccessor(testNode);
		TreeNode<Integer> p = b.getPredecessor(testNode);
		
		if(nonNull(s)) {
			System.out.format("Successor of %s is %s%n", testNode.elem, s.elem);
		}else {
			System.out.format("Successor of %s is null", testNode.elem);
		}
		
		if(nonNull(p)) {
			System.out.format("Predecessor of %s is %s%n", testNode.elem, p.elem);
		}else {
			System.out.format("Predecessor of %s is null", testNode.elem);
		}
		
		System.out.format("Max is: %s%n", b.getMax());
		System.out.format("Min is: %s%n", b.getMin());
		
		System.out.format("Is balanced: %s%n", b.isBalanced());
		
		b.printTree(b.getRoot());
		
		System.out.println();
		
		b.deleteNode(6);
		
		b.printTree(b.getRoot());
		
		System.out.println();
		
		b.deleteNode(15);
		
		b.printTree(b.getRoot());
		
		System.out.println();
		
		System.out.format("Is BST: %s%n", b.isBST());
		

	}
	
	public boolean isBalanced() {
		
		if(isNull(root)) return true;
		
		return getHeight(root) != Integer.MIN_VALUE;
	}
	
	private int getHeight(TreeNode<E> node) {
		
		if(isNull(node)) return -1;
		
		int leftMin = getHeight(node.left);
		
		if(leftMin == Integer.MIN_VALUE) return leftMin;
		
		int rightMin = getHeight(node.right);
		
		if(rightMin == Integer.MIN_VALUE) return rightMin;
		
		if(Math.abs(leftMin - rightMin) > 1) {
			return Integer.MIN_VALUE;
		}else {
			return Math.max(leftMin, rightMin) + 1;
		}
		
	}
	
	public boolean isBST() {
		return checkIfIsBST(root, null, null);
	}
	
	private boolean checkIfIsBST(TreeNode<E> node, Integer min, Integer max) {
		
		if(isNull(node)) return true;
		
		Integer elem = ((Integer) node.elem);
		
		if((nonNull(min) && elem <= min) || (nonNull(max) && elem > max)) {
			return false;
		}
		
		if(!checkIfIsBST(node.left, min, (Integer) node.elem) || !checkIfIsBST(node.right, (Integer) node.elem, max)) {
			return false;
		}
		
		return true;
		
	}
	
	public void deleteNode(E e) {
		
		TreeNode<E> deletedNode = findNodeWithValue(e);
		
		if(isNull(deletedNode.right)) {
			if(isNull(deletedNode.left)) {
				if(isRightChild(deletedNode)) {
					deletedNode.parent.right = null;
				}else if(isLeftChild(deletedNode)) {
					deletedNode.parent.left = null;
				}
			}else {
				if(isRightChild(deletedNode)) {
					deletedNode.parent.right = deletedNode.left;
				}else if(isLeftChild(deletedNode)) {
					deletedNode.parent.left = deletedNode.left;
				}
			}
		}else {
			
			TreeNode<E> leftMostChild = getLeftMost(deletedNode.right);
			
			deletedNode.elem = leftMostChild.elem;
			
			if(isLeftChild(leftMostChild)) {
				leftMostChild.parent.left = leftMostChild.right;
			}else if(isRightChild(leftMostChild)) {
				leftMostChild.parent.right = leftMostChild.right;
			}
			
			leftMostChild.right = null; leftMostChild.parent = null;
			
		}
		
	}
	
	private boolean isRightChild(TreeNode<E> node) {
		
		if(isNull(node) || isNull(node.parent)) return false;
		
		return node.equals(node.parent.right);
	}
	
	private boolean isLeftChild(TreeNode<E> node) {
		
		if(isNull(node) || isNull(node.parent)) return false;
		
		return node.equals(node.parent.left);
		
	}
	
	
	public TreeNode<E> findNodeWithValue(E e) {
		return bfs(root, e);
	}
	
	private TreeNode<E> bfs(TreeNode<E> node, E e) {
		
		if(isNull(node)) return null;
		
		if(node.elem.equals(e)) {
			return node;
		}else if(node.elem.compareTo(e) > 0) {
			return bfs(node.left, e);
		}else {
			return bfs(node.right, e);
		}
	}
	
	public TreeNode<E> getSuccessor(TreeNode<E> node) {
		
		if(nonNull(node) && isNull(node.parent)) return null;

		TreeNode<E> sucessor = null;
		if(nonNull(node.right)) { // If has right children, the leftmost of it 1st right children is the successor
			sucessor = getLeftMost(node.right);
		}else { // If it does not have right children, then it´s successor needs to be one of it´s parents.
			TreeNode<E> parent = node.parent;
			TreeNode<E> me = node;
			while(nonNull(parent) && parent.left != me) {
				me = parent;
				parent = parent.parent;
			}
			sucessor = parent;
		}
		
		return sucessor;
		
	}
	
	public TreeNode<E> getPredecessor(TreeNode<E> node) {
		
		if(nonNull(node) && isNull(node.parent)) return null;
		
		TreeNode<E> predecessor = null;
		
		// If it has left children, the predecessor is the rightmost child of it´s first left child
		if(nonNull(node.left)) {
			predecessor = getRightMost(node.left);
		} // If it does not have left children, then it does not have a predecessor since any parent would be greater
		
		return predecessor;
		
	}
	
	public TreeNode<E> getMax() {
		return getRightMost(root);
	}
	
	private TreeNode<E> getRightMost(TreeNode<E> node) {
		if(nonNull(node) && isNull(node.right)) return node;
		return getRightMost(node.right);
	}
	
	public TreeNode<E> getMin() {
		return getLeftMost(root);
	}
	
	private TreeNode<E> getLeftMost(TreeNode<E> node) {
		if(nonNull(node) && isNull(node.left)) return node;
		return getLeftMost(node.left);
	}
	
	public static BinarySearchTree<Integer> getFilledTree() {
		
		BinarySearchTree<Integer> b = new BinarySearchTree<>();
		
		b.add(15);
		b.add(18);
		b.add(6);
		b.add(17);
		b.add(20);
		b.add(3);
		b.add(7);
		//b.add(13);
		//b.add(9);
		b.add(2);
		b.add(4);
		//b.add(5);
		//b.add(8);
		
		return b;
		
	}
	
	
	private TreeNode<E> root;
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(E e) {
		if(nonNull(e)) {
			root = new TreeNode<>(e);
		}
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}
	
	public boolean add(E e) {
		if(isNull(e)) return false;
		
		if(isNull(root)) {
			root = new TreeNode<>(e);
			testNode = root;
			return true;
		}else {
			return add(root, e);
		}
	}
	
	private boolean add(TreeNode<E> node, E e) {
		if(isNull(node)) return false;
		if(node.elem.compareTo(e) < 0) {
			if(isNull(node.right)) {
				node.right = new TreeNode<>(e, node); if(e.equals(val)) {testNode = node.right;}
			}else {
				return add(node.right, e); // Propagate the boolean response.
			}
		}else if(node.elem.compareTo(e) > 0) {
			if(isNull(node.left)) {
				node.left = new TreeNode<>(e, node); if(e.equals(val)) {testNode = node.left;}
			}else {
				return add(node.left, e); // Propagate the boolean response.
			}
		}else {
			return false;
		}
		return true;
	}
	
	public void printTree(TreeNode<E> node) {
		
		if(isNull(node)) return;
		
		printTree(node.left);
		System.out.print(node.elem + " ");
		printTree(node.right);
		
	}
	
	public static class TreeNode<E> {
		
		TreeNode<E> left;
		TreeNode<E> right;
		TreeNode<E> parent;
		
		E elem;
		
		public TreeNode() {}
		public TreeNode(E e) {
			this.elem = e;
		}
		
		public TreeNode(E e, TreeNode<E> parent) {
			this.elem = e;
			this.parent = parent;
		}
		
		@Override
		public String toString() {
			return elem.toString();
		}
		
	}

}
