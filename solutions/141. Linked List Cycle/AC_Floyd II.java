	/**
	 * 在Linded List Cycle I的基础上再求出环的起始节点
	 * 
	 *
	 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
			return null;
		
		ListNode slow = head;
		ListNode fast = head;
		do{
			if(fast == null || fast.next == null) return null;
			
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