package leetcode;

import java.util.PriorityQueue;

/**
 * description:
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-03 11:06
 */
public class KthLargestElementInAStream703 {
    public static void main(String[] args) {
        KthLargest k = new KthLargest(1, new int[]{});
        System.out.println(k.add(-3));
        System.out.println(k.add(-2));
        System.out.println(k.add(-4));
        System.out.println(k.add(0));
        System.out.println(k.add(4));
    }
}

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int size = 0;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue(size);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (pq.size() == size) {
            if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }
        } else {
            pq.add(val);
        }
        return pq.peek();
    }
}