package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * description:
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-02 17:15
 */
public class BackspaceStringCompare844 {
    // 栈 时间复杂度 O(n) 空间复杂度O(n)
    public boolean backspaceCompare(String S, String T) {
        return fix(S).equals(fix(T));
    }

    private String fix(String s) {
        Deque stack = new ArrayDeque();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.offerFirst(c);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            char c = (char) stack.pollFirst();
            if (c == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare844().backspaceCompare("a##c", "#a#c"));
    }
}
