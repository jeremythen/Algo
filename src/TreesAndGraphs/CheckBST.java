package TreesAndGraphs;

public class CheckBST {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode();
		
		node.data = 6;
		
		node.left = new TreeNode();
		node.right = new TreeNode();
		
		node.left.data = 3;
		node.right.data = 9;
		
		node.left.left = new TreeNode();
		node.left.right = new TreeNode();
		
		node.left.left.data = 1;
		node.left.right.data = 4;
		
		node.right.left = new TreeNode();
		node.right.right = new TreeNode();
		
		node.right.left.data = 7;
		node.right.right.data = 11;
		
		
		System.out.println(checkBST(node));
	}
	
	
	
	static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	static boolean checkBST(TreeNode node, Integer min, Integer max) {
		
		
		if(node == null) {
			return true;
		}
		
		System.out.format("n: %s, min: %s, max %s%n", node, min, max);
		
		if((min != null && node.data <= min) || (max != null && node.data > max)) {
			return false;
		}
		
		if(!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)) {
			return false;
		}
		
		return true;
		
		
	}
	
	
}

class TreeNode {
	
	TreeNode left;
	TreeNode right;
	int data;
	
	public String toString() {
		return "[data " + data + "]";
	}
	
}