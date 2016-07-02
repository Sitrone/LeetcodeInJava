> [reverse-linked-list](https://leetcode.com/articles/reverse-linked-list/)  

The recursive version is slightly trickier and the key is to work backwards. Assume that the rest of the list had already been reversed, now how do I reverse the front part? Let's assume the list is: n1 ¡ú ¡­ ¡ú nk-1 ¡ú nk ¡ú nk+1 ¡ú ¡­ ¡ú nm ¡ú ?

Assume from node nk+1 to nm had been reversed and you are at node nk.

n1 ¡ú ¡­ ¡ú nk-1 ¡ú nk ¡ú nk+1 ¡û ¡­ ¡û nm

We want nk+1¡¯s next node to point to nk.

So,

nk.next.next = nk;

Be very careful that n1's next must point to ?. If you forget about this, your linked list has a cycle in it. This bug could be caught if you test your code with a linked list of size 2.

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
```