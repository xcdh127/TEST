package codetophuawei;

import java.util.Stack;

/*给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
整数除法仅保留整数部分。
你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
示例 1：
输入：s = "3+2*2"
输出：7
示例 2：
输入：s = " 3/2 "
输出：1
示例 3：
输入：s = " 3+5 / 2 "
输出：5
提示：
1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
题目数据保证答案是一个 32-bit 整数
*/
public class Test227 {

    public static void main(String[] args) {
        System.out.println(calculate(" 3/2 "));
    }

    static int i = 0;

    public static int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        //定义初始符号为+
        char prev = '+';
        while (i < n) {
            //取出i位置的字符
            char ch = s.charAt(i);
            //如果是数字
            if (Character.isDigit(ch)) {
                int numStr = getNum(s);
                //符号是+
                if (prev == '+') {
                    stack.push(numStr);
                }
                //符号是-
                else if (prev == '-') {
                    stack.push(-numStr);
                }
                //符号是*
                else if (prev == '*') {
                    int prevNum = stack.pop();
                    int res = prevNum * numStr;
                    stack.push(res);
                }
                //符号是/
                else if (prev == '/') {
                    int prevNum = stack.pop();
                    int res = prevNum / numStr;
                    stack.push(res);
                }
            }
            //如果是字符
            else if (ch == '+') {
                prev = '+';
                i++;
            } else if (ch == '-') {
                prev = '-';
                i++;
            } else if (ch == '*') {
                prev = '*';
                i++;
            } else if (ch == '/') {
                prev = '/';
                i++;
            } else if (ch == ' ') {
                i++;
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static int getNum(String s) {
        int n = s.length();
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i) - '0';
            i++;
        }
        return num;
    }
}

class Solution89 {
    int i = 0;

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        char prev = '+';
        int n = s.length();
        while (i < n) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                String numStr = getNum(s);
                int num = Integer.valueOf(numStr);
                if (prev == '+') {
                    stack.push(num);
                } else if (prev == '-') {

                    stack.push(-num);
                } else if (prev == '*') {
                    int temp = stack.pop();
                    int res = temp * num;
                    stack.push(res);

                } else if (prev == '/') {
                    int temp = stack.pop();
                    int res = temp / num;
                    stack.push(res);
                }
            } else if (ch == '+') {
                prev = '+';
                i++;
            } else if (ch == '-') {
                prev = '-';
                i++;
            } else if (ch == '*') {
                prev = '*';
                i++;
            } else if (ch == '/') {
                prev = '/';
                i++;
            } else {
                i++;
            }
        }
        int res = 0;
        for (int num : stack) {

            res += num;

        }
        return res;

    }

    public String getNum(String s) {

        int index = i;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            i++;
        }
        return s.substring(index, i);
    }
}
