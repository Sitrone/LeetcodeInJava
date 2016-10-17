package leetcode;

import java.util.Random;

public class LinkedListRandomNode {

	public class ListNode{
		private ListNode next;
		private int val;
		
		public ListNode(int val){
			this.val = val;
		}
	}
	
	private ListNode head;
	private Random random;
	
	public LinkedListRandomNode(ListNode head){
		this.head = head;
		this.random = new Random();
	}
	
    /** Returns a random node's value. */
	// ÐîË®³ØËã·¨
    public int getRandom() {
        ListNode res = null;
        ListNode p = this.head;
        for(int i = 1; p != null; i++, p = p.next ){
        	if(random.nextInt(i) == 0){
        		res = p;
        	}
        }
        
        return res.val;
    }
}
