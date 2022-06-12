package Leetcode;
/*请你设计一个可以解释字符串 command 的 Goal 解析器 。
command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
然后，按原顺序将经解释得到的字符串连接成一个字符串。
给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
*/
/*输入：command = "G()(al)"
输出："Goal"
解释：Goal 解析器解释命令的步骤如下所示：
G -> G
() -> o
(al) -> al
最后连接得到的结果是 "Goal"
*/
public class Test128 {
    public String interpret(String command) {
        int n=command.length();
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char ch=command.charAt(i);
            //如果当前字符是G，将G拼接字符串
            if (ch=='G'){
                sb.append('G');
            }
            //如果是左括号
            else if (ch=='('){
                //一直遍历到右括号位置
                int index=i;
                while (index<n && command.charAt(index)!=')'){
                    index++;
                }
                //将左括号到右括号从字符串中截取出来
                String str=command.substring(i,index+1);
                //更新i下标
                i=index-1;
                //如果字符串是"()",解析成o
                if (str.equals("()")){
                    sb.append("o");
                }
                //如果字符串是(al)解析成al
                else {
                    sb.append("al");
                }
            }
            //如果遇到'/'跳过
            else if (ch=='/'){
                continue;
            }
        }
        return sb.toString();
    }
}
