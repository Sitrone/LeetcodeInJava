public class Floyd {
	/**
	 * Floyd判圈算法（双指针）
	 * @param head
	 * @return 
	 */
	public boolean hasCycle(ListNode head){
		if(head == null || head.next == null)
			return false;
		
		ListNode slow = head;
		ListNode fast = head;
		do{
			if(fast == null || fast.next == null) return false;
			
			slow = slow.next;
			fast = fast.next.next;
		}while(slow != fast);
		return true;
	}
	
	/**
	 * 如果存在环，则求出环长
	 * @param head
	 * @return
	 */
    public int countCycleLength(ListNode head) {
    	if(!hasCycle(head)){
    		return 0;
    	}
		ListNode slow = head;
		ListNode fast = head;
		do{
			slow = slow.next;
			fast = fast.next.next;
		}while(slow != fast);
		int cycleLength = 0;
		do{
			slow = slow.next;
			fast = fast.next.next;
			cycleLength++;
		}while(slow != fast);
		return cycleLength;
    }
    
    public ListNode detectCycle(ListNode head) {
    	if(!hasCycle(head)){
    		return null;
    	}
		ListNode slow = head;
		ListNode fast = head;
		do{
			slow = slow.next;
			fast = fast.next.next;
		}while(slow != fast);
		
		ListNode start = head;
		while(slow != start){
			slow = slow.next;
			start = start.next;
		}
		return start;
    }
}