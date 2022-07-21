package codeTop;

import java.util.Deque;
import java.util.LinkedList;

/*给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
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
s由小写英文字母、数字和方括号'[]' 组成
s保证是一个有效的输入。
s中所有整数的取值范围为[1, 300]
*/
public class Test394 {
    public String decodeString(String s) {
        //存放字符的栈
        LinkedList<String> charStack = new LinkedList<>();
        //存放数字的栈
        LinkedList<Integer> numStack=new LinkedList<>();
        //结果字符串
        StringBuilder sb=new StringBuilder();
        char[] ch = s.toCharArray();
        int n = ch.length;
        int num=0;
        for (int i = 0; i < n; i++) {
            char c=ch[i];
            //当遇到'['时
            if (c=='['){
                //将当前数字添加到队列中
                numStack.addLast(num);
                //将字符串添加到字符栈中
                charStack.addLast(sb.toString());
                //num=0
                num=0;
                //字符串sb更新
                sb=new StringBuilder();
            }
            //当遇到']'时，将数字栈顶的元素弹出
            //这个就是重复字符串的次数
            else if (c == ']') {
                //弹出当前重复字符串的次数
                int curNum=numStack.removeLast();
                //temp存放重复curNum次的字符串
                StringBuilder temp=new StringBuilder();
                //重复字符串sb，curNum次
                for (int j = 0; j < curNum; j++) {
                    temp.append(sb);
                }
                //将字符串栈的末尾字符串弹出+temp字符串，作为新的字符串
                sb=new StringBuilder(charStack.removeLast()+temp);
            }
            //当前字符是数字时，形成重复次数
            else if (Character.isDigit(c)) {
                num=num*10+(c-'0');
            }
            //当遇到的是字符时
            else {
                sb.append(c);
            }
        }
        //输出最终结果
        return sb.toString();
    }
}
