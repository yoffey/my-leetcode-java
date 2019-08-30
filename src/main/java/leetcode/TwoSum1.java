package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-06-27 13:41
 */
public class TwoSum1 {

    // 1.暴力破解法  时间复杂度 O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum value");
    }

    // 2.set || map  set可能要字符串拼接，直接用map  时间复杂度 O(n)
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum value");
    }


    public static void main(String[] args) {
//        int[] res = new TwoSum1().twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] res = new TwoSum1().twoSumMap(new int[]{2, 7, 11, 15}, 9);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
