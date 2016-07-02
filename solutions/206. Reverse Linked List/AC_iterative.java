	/**
	 * 迭代法，原地置换
	 * 
	 *
	 */
/**
 * Definition for singly-linked list.
 * public class ListNode { *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}