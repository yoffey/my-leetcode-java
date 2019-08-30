package leetcode;

import java.util.ArrayDeque;

/**
 * description:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-01 16:13
 */
public class ReverseNodesInKGroup25 {
    // 栈 时间复杂度O(n*k) 空间复杂度O(n)
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            // 遍历k之后，tmp指向反转区间的下一个节点
            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }
            // 最后一个区间不等于k，不反转退出循环
            if (count != k) {
                p.next = head;
                break;
            }
            // 对需要反转的区间做反转
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            // 反转区间最后一个节点指向到下一个区间的第一个节点
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    // 递归法 时间复杂度 O(n*k)  空间复杂度O(1)
    public ListNode reverseKGroup2(ListNode head, int k) {
        int count = 0;
        ListNode tmp = head;
        while (tmp != null && count < k) {
            tmp = tmp.next;
            count++;
        }
        if (count == k) {
            ListNode end = head;
            ListNode pre = null;
            while (count > 0) {
                ListNode target = head.next;
                head.next = pre;
                pre = head;
                head = target;
                count--;
            }
            end.next = reverseKGroup2(head, k);
            return pre;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(5);
        head.next = null;
//        next2.next = next3;
//        next3.next = next4;
//        next4.next = next5;
//        next5.next = null;
        ReverseNodesInKGroup25 r = new ReverseNodesInKGroup25();
        head = r.reverseKGroup2(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
