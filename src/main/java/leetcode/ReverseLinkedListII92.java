package leetcode;

/**
 * description:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-01 11:12
 */
public class ReverseLinkedListII92 {
    // 迭代法 待优化
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode first = head, pre = null, next = null, mNode = null, preMNode = null;
        while (head != null) {
            if (n == 1 || m == n) {
                break;
            }
            if (index < m || index > n) {
                if (index == m - 1) {
                    preMNode = head;
                }
                if (index == n + 1) {
                    mNode.next = head;
                }
                head = head.next;
            } else {
                next = head.next;
                if (index == n) {
                    if (head.next == null) {
                        mNode.next = null;
                    }
                    if (m == 1) {
                        first = head;
                    } else {
                        preMNode.next = head;
                    }
                }
                // m->n+1
                if (index == m) {
                    mNode = head;
                } else {
                    head.next = pre;
                }
                pre = head;
                head = next;
            }
            index++;
        }
        return first;
    }

    // 迭代法 优化版
    // 原理：找到m-1的节点定义为start，该节点之后到n的节点都需要反转，把m节点定义为p，遍历每次都把p的下一个节点移动到start之后
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode start = h;
        for (int i=0; i<m-1; i++){
            start = start.next;
        }
        ListNode p = start.next;
        for (int i=m; i<n; i++) {
            if (p == null || p.next == null) {
                break;
            }
            ListNode target = p.next;
            p.next = target.next;
            target.next = start.next;
            start.next = target;
        }
        return h.next;
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
        ReverseLinkedListII92 r = new ReverseLinkedListII92();
        head = r.reverseBetween2(head, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
