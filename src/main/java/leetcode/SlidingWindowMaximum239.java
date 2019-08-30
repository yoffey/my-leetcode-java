package leetcode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * description:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 *
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-04 09:31
 */
public class SlidingWindowMaximum239 {
    // 堆 or 优先队列 时间复杂度 O(nlogk)
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> window = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - (k - 1)];
        int i = 0;
        int willRmIndex = 0;
        for (int num : nums) {
            if (window.size() < k) {
                window.add(num);
                if (window.size() == k) {
                    res[i++] = window.peek();
                }
            } else {
                window.remove(nums[willRmIndex++]);
                window.add(num);
                res[i++] = window.peek();
            }
        }
        return res;
    }

    // 双端队列 时间复杂度 O(n)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> window = new ArrayDeque<>(k);
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - (k - 1)];
        int rIndex = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            // k的左界下标必须大于i-k,否则window的理论大小会超过k
            if (i >= k && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[i] > nums[window.peekLast()]) {
                window.pollLast();
            }
            window.offer(i);
            if (i >= k - 1) {
                res[rIndex++] = nums[window.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new SlidingWindowMaximum239().maxSlidingWindow2(new int[]{1,3,1,2,0,5}, 3);
        for (int re : res) {
            System.out.print(re + ", ");
        }
    }
}
