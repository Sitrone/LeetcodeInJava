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
    private List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            helper(root);
        }
        return res;
    }
    
    private void helper(TreeNode root) {
        if (root != null) {
            helper(root.left);
            res.add(root.val);
            helper(root.right);        
        }
    }
}