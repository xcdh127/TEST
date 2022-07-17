package HOT100;

import java.util.LinkedList;

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
        StringBuilder res=new StringBuilder();
        //存放当前字符串
        LinkedList<String> charStack=new LinkedList<>();
        //存放字符串的重复次数
        LinkedList<Integer> numStack=new LinkedList<>();
        char[] ch=s.toCharArray();
        int n=ch.length;
        int num=0;
        for (int i = 0; i < n; i++) {
            //当遇到左括号时，将当前字符串添加到存放字符串的栈中,将num赋值为0，更新StringBuilder
            if (ch[i]=='['){
                numStack.addLast(num);
                charStack.addLast(res.toString());
                num=0;
                res=new StringBuilder();
            }
            //当遇到的字符是右括号时
            else if (ch[i]==']') {
                //将栈顶的元素弹出，这就是字符串要重复的次数
                int curNum=numStack.removeLast();
                //添加这个括号内的字符串到结果中
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < curNum; j++) {
                    sb.append(res);
                }
                //更新结果，将之前的字符串，添加上当前的字符串
                res=new StringBuilder(charStack.removeLast()+sb);
            }
            //当遇到的上是数字时，拼接重复多少次当前字符串
            else if (Character.isDigit(ch[i])) {
                num=num*10+(ch[i]-'0');
            }
            //当遇到的是字符时，向res中添加当前字符串
            else {
                res.append(ch[i]);
            }
        }
        return res.toString();
    }
}

/*class Solution {
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        LinkedList<String> charStack=new LinkedList<>();
        LinkedList<Integer> numStack=new LinkedList<>();
        char[] ch=s.toCharArray();
        int n=ch.length;
        int num=0;
        for(int i=0;i<n;i++){
            if(ch[i]=='['){
                numStack.addLast(num);
                charStack.addLast(res.toString());
                num=0;
                res=new StringBuilder();
            }
            else if(ch[i]==']'){
                int curNum=numStack.removeLast();
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<curNum;j++){
                    sb.append(res);
                }
                res=new StringBuilder(charStack.removeLast()+sb);
            }
            else if(Character.isDigit(ch[i])){
                num=num*10+(ch[i]-'0');
            }
            else{
            res.append(ch[i]);
            }
        }
        return res.toString();
    }
}*/
