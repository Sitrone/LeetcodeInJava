	/**
	 * 1、Floyd判圈法（之前一直叫双指针跑圈法来着）
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
    public boolean hasCycle(ListNode head) {
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
}