package TreesAndGraphs;

public class CheckBST {

	public static void main(String[] args) {
		
		TreeNode n = new TreeNode();
		
		n.data = 6;
		
		n.left = new TreeNode();
		n.right = new TreeNode();
		
		n.left.data = 3;
		n.right.data = 9;
		
		n.left.left = new TreeNode();
		n.left.right = new TreeNode();
		
		n.left.left.data = 1;
		n.left.right.data = 4;
		
		n.right.left = new TreeNode();
		n.right.right = new TreeNode();
		
		n.right.left.data = 7;
		n.right.right.data = 11;
		
		
		System.out.println(checkBST(n));
	}
	
	
	
	static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	static boolean checkBST(TreeNode n, Integer min, Integer max) {
		
		
		if(n == null) {
			return true;
		}
		
		System.out.format("n: %s, min: %s, max %s%n", n, min, max);
		
		if((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		
		if(!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
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