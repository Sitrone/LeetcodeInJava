###�ο�
1. [wiki Floyd](https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare)

###�ж������л���������⣺
1�������Ƿ��л�
> ˫ָ�룬һ��slowһ��һ����һ��fastһ��������������������л������fastָ��null�����޻���

[Leetcode ����:141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

2������л����󻷵ĳ���
> ���ϣ�˫ָ�룬��һ��������ʼ�������ٴ���������Ϊ����

3���󻷵����
> ���ʼ��㵽����������Ϊ**m**�����ĳ���Ϊ**n**����һ������ʱ����뻷�����Ϊ**k**
  ��һ������slow�ܵĽڵ��� i = m + a * n + k   ��1��
  ��һ������fast�ܵĽڵ��� 2i = m + b * n + k   ��2��
  ��2�� - ��1���� i = (b - a) * n
  ��֪���ڵ��ܵľ���Ϊ���������������� m + k = c * n,Ҳ���ǣ�
  ����������һ���µ�ָ��ָ����ʼ�ڵ�new����ʼ��������new��slow����ʱ���������ǻ������
  
[Leetcode ����:142: Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)