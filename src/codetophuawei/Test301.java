package codetophuawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
返回所有可能的结果。答案可以按 任意顺序 返回。
示例 1：
输入：s = "()())()"
输出：["(())()","()()()"]
示例 2：
输入：s = "(a)())()"
输出：["(a())()","(a)()()"]
示例 3：
输入：s = ")("
输出：[""]

提示：
1 <= s.length <= 25
s 由小写英文字母以及括号 '(' 和 ')' 组成
*/
public class Test301 {
    Set<String> set = new HashSet<>();
    int n;
    char[] ch;

    public List<String> removeInvalidParentheses(String s) {
        ch = s.toCharArray();
        n = s.length();
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '(') {
                leftRemove++;
            } else if (ch[i] == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else if (leftRemove == 0) {
                    rightRemove++;
                }
            }
        }
        recur(ch, 0, 0, leftRemove, rightRemove, new StringBuilder(), 0);
        return new ArrayList<>(set);
    }

    public void recur(char[] ch, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder sb, int index) {
        //指针指向数组的末尾
        if (index == n) {
            //待删除的左括号和右括号都为0时
            if (leftRemove == 0 && rightRemove == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char curChar = ch[index];
        //删除当前字符
        if (curChar == '(' && leftRemove > 0) {
            recur(ch, leftCount, rightCount, leftRemove - 1, rightRemove, sb, index + 1);
        }
        if (curChar == ')' && rightRemove > 0) {
            recur(ch, leftCount, rightCount, leftRemove, rightRemove - 1, sb, index + 1);
        }

        //保留当前字符
        sb.append(curChar);

        //当前字符是英文字符
        if (Character.isLetter(curChar)) {
            recur(ch, leftCount, rightCount, leftRemove, rightRemove, sb, index + 1);
        }

        //当前字符是左括号，添加左括号
        else if (curChar == '(') {
            recur(ch, leftCount + 1, rightCount, leftRemove, rightRemove, sb, index + 1);
        }

        //当前左括号的数量大于右括号，添加右括号
        else if (leftCount > rightCount) {
            recur(ch, leftCount, rightCount + 1, leftRemove, rightRemove, sb, index + 1);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}


class Solution178 {
    Set<String> validString;
    int len;
    char[] ch;

    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        ch = s.toCharArray();
        validString = new HashSet<>();
        //遍历字符串，拿到多余的左括号以及右括号的数量
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < len; i++) {
            //遇到左括号，将此时的待删除的左括号数量+1
            if (ch[i] == '(') {
                leftRemove++;
            }
            //遇到右括号，将此时的待删除的右括号数量+1
            else if (ch[i] == ')') {
                //当左括号的数量大于0时，此时抵消一个左括号
                if (leftRemove > 0) {
                    leftRemove--;
                }
                //当左括号的数量为0时，多余一个右括号
                else if (leftRemove == 0) {
                    rightRemove++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        recur(0, 0, 0, leftRemove, rightRemove, sb);
        return new ArrayList<>(validString);

    }

    public void recur(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder sb) {
        //当遍历完字符串时
        if (index == len) {
            //需要删除的左右括号都为0时
            if (leftRemove == 0 && rightRemove == 0) {
                //向set集合中添加符合条件的字符串
                validString.add(sb.toString());
            }
            //否则跳出
            return;
        }
        //取出当前的字符
        char curChar = ch[index];
        //(1)删除当前遍历到的字符，删除就是不向sb中添加该字符
        //如果当前遇到的是左括号，并且剩余可以删除的左括号大于0时，删除左括号
        if (curChar == '(' && leftRemove > 0) {
            //leftRemove数量-1，作为入参
            recur(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, sb);
        }
        //如果当前遇到的是右括号，并且剩余可以删除的右括号大于0时，删除右括号
        if (curChar == ')' && rightRemove > 0) {
            //rightRemove数量-1，作为入参
            recur(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, sb);
        }
        //(2)保留当前遍历到的字符
        //将当前字符拼接到sb中
        sb.append(curChar);
        //如果当前字符是英文字符，此时leftCount和rightCount的数量都不改变
        if (curChar != '(' && curChar != ')') {
            recur(index + 1, leftCount, rightCount, leftRemove, rightRemove, sb);
        }
        //如果当前字符是左括号，左括号leftCount+1作为入参数
        else if (curChar == '(') {
            recur(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, sb);
        }
        //左括号的数量大于右括号的数量时，此时可以保存右括号，右括号rightCount+1作为入参
        else if (leftCount > rightCount) {
            recur(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, sb);
        }
        //恢复sb为父节点时的状态
        sb.deleteCharAt(sb.length() - 1);
    }
}