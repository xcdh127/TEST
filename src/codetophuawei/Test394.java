package codetophuawei;

import java.util.LinkedList;
import java.util.Stack;

/*给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
提示：
1 <= s.length <= 30
s 由小写英文字母、数字和方括号 '[]' 组成
s 保证是一个 有效 的输入。
s 中所有整数的取值范围为 [1, 300] 
*/
public class Test394 {
    public String decodeString(String s) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int n = ch.length;
        //记录数字出现的次数
        int num = 0;
        for (int i = 0; i < n; i++) {
            //取出当前字符
            char temp = ch[i];
            //如果当前字符是 [ 时
            if (temp == '[') {
                //将当前重复字符串次数放进数字栈中
                numStack.add(num);
                //当前括号内的字符串放进栈中
                charStack.add(sb.toString());
                //更新数字为0
                num = 0;
                //重新赋值字符串
                sb = new StringBuilder();
            }
            //当前字符是 ] 时
            else if (temp == ']') {
                //弹出当前字符串
                int curNum = numStack.pop();
                //更新字符串
                StringBuilder curSb = new StringBuilder();
                //重复次数
                for (int j = 0; j < curNum; j++) {
                    curSb.append(sb);
                }
                //将拼接字符串后更新字符串
                sb = new StringBuilder(charStack.pop() + temp);
            }
            //如果是一个数字
            else if (Character.isDigit(temp)) {
                num = num * 10 + temp - '0';
            }
            //当遇到英文字符时
            else {
                sb.append(temp);
            }
        }
        //输出字符串
        return sb.toString();
    }
}


class Solution94 {
    public String decodeString(String s) {
        LinkedList<String> charStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = ch[i];
            //当遇到'['时
            if (c == '[') {
                //将当前数字添加到队列中
                numStack.addLast(num);
                //将字符串添加到字符栈中
                charStack.addLast(sb.toString());
                //num=0
                num = 0;
                //字符串sb更新
                sb = new StringBuilder();
            }
            //当遇到']'时，将数字栈顶的元素弹出
            //这个就是重复字符串的次数
            else if (c == ']') {
                int curNum = numStack.removeLast();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < curNum; j++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(charStack.removeLast() + temp);
            }
            //当前字符是数字时，形成重复次数
            else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            //当遇到的是字符时
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}