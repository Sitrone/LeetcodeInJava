package leecode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

	public static void main(String[] args) {
		//	    3
		//	    / \
		//	   9  20
		//	     /  \
		//	    15   7
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(20);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(7);
		root.left = a;
		root.right = b;
		
		b.left = c;
		b.right = d;
		
		System.out.println(sumOfLeftLeaves2(root));
	}

	/**
	 * recursive 
	 * @param root
	 * @return
	 */
    public static int sumOfLeftLeaves(TreeNode root) {
    	int result = 0;
    	if(root == null){
    		return 0;
    	}
    	// 关键是要找到终止的左节点，即root.left != null,但是root.left.left == null 与 root.left.right == null
    	if(root.left != null ){
    		if(root.left.left == null && root.left.right == null){
    			result += root.left.val;
    		}
    	}
    	
    	result += sumOfLeftLeaves(root.left);
    	result += sumOfLeftLeaves(root.right);
    	
    	return result;
    }
    
    public static int sumOfLeftLeaves2(TreeNode root) {
    	int result = 0;
    	if(root == null){
    		return 0;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(queue.size() != 0){
    		TreeNode node = queue.poll();
    		if(node.left != null){
    			queue.offer(node.left);
    			if(node.left.left == null && node.left.right == null){
    				result += node.left.val;
    			}
    		}
    		if(node.right != null){
    			queue.offer(node.right);
    		}
    	}
    	
    	return result;
    }
}
