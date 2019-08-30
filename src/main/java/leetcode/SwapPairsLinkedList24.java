package leetcode;

/**
 * description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 注意点：考虑链表个数为奇数的情况
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-06-28 14:37
 */
public class SwapPairsLinkedList24 {
    // 迭代法 O(n)
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null, res = head;
        while (head != null && head.next != null) {
            if (pre != null) {
                pre.next = head.next;
            } else {
                res = head.next;
            }
            ListNode tempNode = head.next.next;
            head.next.next = head;
            head.next = tempNode;
            pre = head;
            head = head.next;
        }
        return res;
    }

    // 递归法 O(n)
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        ListNode temp = head.next.next;
        head.next.next = head;
        head.next = temp;
        head.next = swapPairs2(temp);
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = null;
        SwapPairsLinkedList24 s = new SwapPairsLinkedList24();
        ListNode res = s.swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}