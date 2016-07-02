/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
 *���Բο�226. Invert Binary Tree�Ľⷨ
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	Stack<TreeNode> st1 = new Stack<TreeNode>();
    	Stack<TreeNode> st2 = new Stack<TreeNode>();
    	
    	st1.add(p);
    	st2.add(q);  
    	while(st1.size() != 0 && st2.size() != 0){
    		p = st1.pop();
    		q = st2.pop();
    		
    		if(p == null || q == null){
    			if(p != q)
    				return false;
    			else
    				continue;
    		}
    		if(p.val != q.val)
    			return false;
    		
    		st1.add(p.left);
    		st1.add(p.right);
    		
    		st2.add(q.left);
    		st2.add(q.right);
    	}
    	return st1.size() == st2.size();
    }
}