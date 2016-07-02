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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
			return true;
		
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(p);
    	queue.offer(q);
    	
    	while(!queue.isEmpty()){
    		p = queue.poll();
    		q = queue.poll();
    		
    		if(p == null || q == null){
    			if(p != q)
    				return false;
    			else
    				continue;
    		}
    		if(p.val != q.val)
    			return false;
    		queue.offer(p.left);
    		queue.offer(q.left);
    		
    		queue.offer(p.right);
    		queue.offer(q.right);
    	}
    	return true;
    }
}