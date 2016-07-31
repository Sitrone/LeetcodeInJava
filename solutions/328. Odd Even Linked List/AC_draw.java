	/**
	 * 
	 * 
	 *
	 */
public class OddEvenList {
	public ListNode oddEvenList(ListNode head){
		if(head == null) return null;
		
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode connectNode = p2;
		while(p2 != null && p2.next != null){
			p1.next = p2.next;
			p1 = p1.next;
					
			p2.next = p1.next;
			p2 = p2.next;
		}
		p1.next = connectNode;
		return head;
	}
}
