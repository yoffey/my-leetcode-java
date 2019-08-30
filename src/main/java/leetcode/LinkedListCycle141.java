package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-06-29 14:01
 */
public class LinkedListCycle141 {
    // 迭代法 时间复杂度O(n) 空间复杂度O(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> indexSet = new HashSet<>();
        while (head != null && head.next != null) {
            if (indexSet.contains(head)) {
                return true;
            }
            indexSet.add(head);
            head = head.next;
        }
        return false;
    }

    // 龟兔赛跑法 时间复杂度O(n) 空间复杂度O(1)
    public boolean hasCycle2(ListNode head) {
        // 乌龟每次走一步   兔子每次走两步
        ListNode turtle = head, rabbit = head;
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(0);
        ListNode next4 = new ListNode(-4);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next2;
        System.out.println(new LinkedListCycle141().hasCycle2(head));
    }
}
