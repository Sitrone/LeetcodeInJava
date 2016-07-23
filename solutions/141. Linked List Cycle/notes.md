###参考
1. [wiki Floyd](https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare)

###判断链表有环的相关问题：
1、链表是否有环
> 双指针，一个slow一次一步，一个fast一次两步，如果相遇，则有环；如果fast指向null，则无环。

[Leetcode 问题:141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

2、如果有环，求环的长度
> 接上，双指针，第一次相遇后开始计数，再次相遇，则为环长

3、求环的起点
> 设初始起点到环的起点距离为**m**，环的长度为**n**，第一次相遇时候距离环的起点为**k**
  第一次相遇slow跑的节点数 i = m + a * n + k   （1）
  第一次相遇fast跑的节点数 2i = m + b * n + k   （2）
  （2） - （1）： i = (b - a) * n
  可知慢节点跑的距离为环长的整数倍，即 m + k = c * n,也就是：
  如重新设置一个新的指针指向起始节点new，开始计数，当new与slow相遇时候，这个点就是环的起点
  
[Leetcode 问题:142: Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)