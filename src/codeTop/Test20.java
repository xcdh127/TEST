package codeTop;

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
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        int n=s.length();
        for (int i = 0; i < n; i++) {
            //当遇到的字符是左括号时，将字符放进栈中
            if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }
            //当遇到的字符是右括号时
            else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                //如果此时栈为空，或者栈顶元素不等于与之匹配的左括号时，返回false
                if (stack.isEmpty() || stack.peek()!=map.get(s.charAt(i))){
                    return false;
                }
                //弹出栈顶的元素
                stack.pop();
            }
        }
        //返回栈是否为空
        return stack.isEmpty();
    }
}
