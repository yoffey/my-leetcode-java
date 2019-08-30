package leetcode;

/**
 * description:反转一个单链表。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-06-28 09:36
 */
class ReverseLinkedList206 {

    // 迭代法 时间复杂度：O(n)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    // 递归  nk.next.next = nk  时间复杂度：O(n)
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(5);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = null;
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        head = reverseLinkedList206.reverseList2(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}