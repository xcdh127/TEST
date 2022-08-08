package CodeDream;

import java.util.Stack;

/*给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
示例：
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
提示：
1 <= S.length <= 20000
S 仅由小写英文字母组成。
*/
public class Test1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //遍历字符串s
        for (int i = 0; i < s.length(); i++) {
            //当栈为空，或者字符串当前字符与栈顶元素不相等时，将当前字符压入栈中
            if (stack.isEmpty() || stack.peek() != chars[i]) {
                stack.push(chars[i]);
            }
            //否则，将栈顶元素弹出
            else {
                stack.pop();
            }
        }
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        //栈是后进先出，反转字符串输出
        return sb.reverse().toString();
    }
}
