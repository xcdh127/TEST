package codeTop;

import java.util.Stack;

/*给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
示例：
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，
这是此时唯一可以执行删除操作的重复项。之后我们得到字符串
 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
提示：
1 <= S.length <= 20000
S 仅由小写英文字母组成。
*/
public class Test1047 {
    public String removeDuplicates(String s) {
        //栈放字符
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //取出当前字符
            char ch = s.charAt(i);
            //当栈不为空，并且栈顶字符等于当前字符
            if (!stack.isEmpty() && stack.peek() == ch) {
                //弹出栈顶元素
                stack.pop();
            }
            //将当前字符，压入栈中
            else {
                stack.push(ch);
            }
        }
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        //当栈不为空时
        while (!stack.isEmpty()) {
            //拼接字符串
            sb.append(stack.pop());
        }
        //栈后进先出，反转字符串
        return sb.reverse().toString();
    }
}

class Solution44 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
//当栈为空时，将当前字符压入栈中
            else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}