package codetophuawei;

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
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        //右括号作为键，左括号作为值，存入map中
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            //如果当前字符是左括号，或者栈为空，就入栈
            if (stack.isEmpty() || temp == '[' || temp == '(' || temp == '{') {
                stack.push(temp);
            }
            //如果是右括号
            else if (temp == '}' || temp == ')' || temp == ']') {
                //如果括号不匹配就返回false
                if (!map.get(temp).equals(stack.peek())) {
                    return false;
                }
                //匹配就弹出栈顶的符号
                stack.pop();
            }
        }
        //返回栈是否为空
        return stack.isEmpty();
    }
}
