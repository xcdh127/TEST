package CodeDream;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
示例 1：
输入：s = "()"
输出：true
示例 2：
输入：s = "()[]{}"
输出：true
示例 3：
输入：s = "(]"
输出：false
示例 4：
输入：s = "([)]"
输出：false
示例 5：
输入：s = "{[]}"
输出：true
提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
*/
public class Test20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        //括号右半部分作为键，左半部分作为值，存入map中
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        //新建栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //取出i位置的字符
            char ch = s.charAt(i);
            //当为左括号时，入栈
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            //当是右括号时
            else {
                //如果此时栈为空，或者栈顶元素与当前括号不匹配，直接返回false
                if (stack.isEmpty() || map.get(ch) != stack.peek()) {
                    return false;
                }
                //当栈顶元素与当前括号匹配时，弹出栈顶元素
                if (map.get(ch) == stack.peek()) {
                    stack.pop();
                }
            }
        }
        //返回栈是否为空
        return stack.isEmpty();
    }
}
