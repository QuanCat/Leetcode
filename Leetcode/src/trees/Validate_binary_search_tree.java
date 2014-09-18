package trees;

public class Validate_binary_search_tree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	int lastVal = Integer.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		
        if(root == null) {
        	return true;
        }
        if (!isValidBST(root.left)) {
        	return false;
        }
        if (lastVal >= root.val) {
        	return false;
        }
        lastVal = root.val;
        if (!isValidBST(root.right)) {
        	return false;
        }

        return true;	
    }
}	
