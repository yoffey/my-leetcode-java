package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-01 09:28
 */
public class LinkedListCycleII142 {
    // 迭代法 时间复杂度O(n) 空间复杂度O(n)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null && head.next != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    // 迭代法 时间复杂度O(n) 空间复杂度O(1) shitcode下面优化一下写法
    public ListNode detectCycle2(ListNode head) {
        ListNode turtle = head, rabbit = head;
        boolean hashCycle = false;
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                hashCycle = true;
                break;
            }
        }
        // 经推算，交汇点到入环点的距离和起点到入环点的距离相等
        // 所以，复用rabbit为head，每次走一步，当和turtle再次相等的时候，就是入环点
        rabbit = head;
        if (hashCycle) {
            // 如果交汇点是起点，则说明起点就是入环点，直接返回
            if (head == turtle) {
                return head;
            }
            while (true) {
                rabbit = rabbit.next;
                turtle = turtle.next;
                if (rabbit == turtle) {
                    return rabbit;
                }
            }
        }
        return null;
    }

    // 优化版
    public ListNode detectCycle3(ListNode head) {
        ListNode turtle = head, rabbit = head, finder = head;
        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) {
                while (finder != turtle) {
                    finder = finder.next;
                    turtle = turtle.next;
                }
                return finder;
            }
        }
        return null;
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
        System.out.println(new LinkedListCycleII142().detectCycle3(head));
    }
}
