package HOT100;

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
public class Test11 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            } else if (ch==')' || ch==']' || ch=='}') {
                if (stack.isEmpty() || !map.get(ch).equals(stack.peek())){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}















