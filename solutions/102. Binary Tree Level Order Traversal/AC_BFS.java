	/**
	 * 
	 * 
	 *
	 */
public class LevelOrder
{
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null) return res;
    	
    	Queue<TreeNode> q = new LinkedList<>();
    	q.offer(root);
    	
    	while(!q.isEmpty())
    	{
    		List<Integer> level = new ArrayList<>();
    		int num = q.size();
    		for(int i = 0; i < num; i++)
    		{
    			TreeNode cur = q.poll();
    			level.add(cur.val);
        		if(cur.left != null) q.offer(cur.left);
        		if(cur.right != null) q.offer(cur.right);
    		}
    		res.add(level);
    	}
    	return res;
    }