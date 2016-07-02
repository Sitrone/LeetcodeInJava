/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root == null){
			return res;
		}
		
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.peek();
			if(root.left != null){
				stack.push(root.left);
				root.left = null;
			}else{
				res.add(root.val);
				stack.pop();
				if(root.right != null){
					stack.push(root.right);
				}
			}
		}
		return res;
    }
}