package trees;

/*
 * time complexity is O(n), because every node visit once
 */
public class Minimum_depth_of_binary_tree {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public int minDepth(TreeNode root) {
		//shortest path form the root node down to the nearest leaf node
		if (root == null) {return 0;}

		return getMin(root);
    }
	
	public int getMin(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.right == null && root.left == null) {
			return 1;
		}
		return Math.min(getMin(root.left), getMin(root.right)) + 1;
	}
}
