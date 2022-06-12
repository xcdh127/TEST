package Leetcode;
/*有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，
其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，
我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
给出一个非空有效字符串 s，考虑将其进行原语化分解，
使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
*/

/*输入：s = "(()())(())"
输出："()()()"*/
public class Test93 {
    public String removeOuterParentheses(String s) {
        //记录中间变量
        StringBuilder sb=new StringBuilder();
        //记录结果
        StringBuilder res=new StringBuilder();
        int n=s.length();
        int i=0;
        //左括号的数量
        int left=0;
        //右括号的数量
        int right=0;
        //当指针没有到达字符串的末尾时
        while (i<s.length()){
            //如果字符串当前位置是左括号
            if (s.charAt(i)=='('){
                left++;
                sb.append('(');
            }
            //如果字符串当前位置是右括号
            else if (s.charAt(i)==')'){
                right++;
                sb.append(')');
            }
            //如果当前sb大于0，并且左右括号数量相等
            if (sb.length()>0 && left==right){
                //此时构成一个括号单元
                //将最外层的括号删除
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);
                //添加到结果中
                res.append(sb);
                //统计下一个有效括号单元
                left=0;
                right=0;
                //更新字符串sb
                sb=new StringBuilder();
            }
            //将指针向后移动一位
            i++;
        }
        //输出结果
        return res.toString();
    }
}
