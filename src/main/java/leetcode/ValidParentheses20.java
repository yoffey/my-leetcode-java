package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 *
 * @author 宗永飞 (yongfei.zong@ucarinc.com)
 * @version 1.0
 * @date 2019-07-03 09:32
 */
public class ValidParentheses20 {

    public boolean isValid(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> left = new HashSet<String>(){{add("(");add("{");add("[");}};
        for (char c : s.toCharArray()) {
            if (!left.contains(String.valueOf(c))) {
                if (stack.isEmpty() || c != stack.peek().charAt(0)) {
                    return false;
                }
                stack.pop();
            } else {
                switch (c) {
                    case '(':
                        stack.push(")");
                        break;
                    case '{':
                        stack.push("}");
                        break;
                    case '[':
                        stack.push("]");
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(new ValidParentheses20().isValid(s));
    }
}
