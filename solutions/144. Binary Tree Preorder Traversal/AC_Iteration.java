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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root != null ){
        	helper(root, res);
        }
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res){
    	if(root != null){
    		res.add(root.val);
    		helper(root.left, res);
    		helper(root.right, res);
    	}
    }
}