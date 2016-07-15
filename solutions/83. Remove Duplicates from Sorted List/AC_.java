	/**
	 * 
	 * 1、如果有重复的，则当前节点指向next的next节点，如果没有，则指向next
	 *
	 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null){
        	if (current.next.val == current.val){
        		current.next = current.next.next;
        	}else{
        		current = current.next;
        	}
        }
        return head;
    }
}