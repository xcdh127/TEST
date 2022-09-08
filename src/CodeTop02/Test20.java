package CodeTop02;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
示例 1：
输入：s = "()"
输出：true
示例 2：
输入：s = "()[]{}"
输出：true
示例 3：
输入：s = "(]"
输出：false
提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
*/
public class Test20 {
    public boolean isValid(String s) {
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //栈为空并且当前位置为右括号
            if (!stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
                //如果栈顶元素不是对应的括号，就返回false
                if (map.get(s.charAt(i)) != stack.peek()) {
                    return false;
                }
                //弹出栈顶元素
                stack.pop();
            }
            //将左括号，压入栈
            else {
                stack.push(s.charAt(i));
            }
        }
        //弹出栈是否为空
        return stack.isEmpty();
    }
}
