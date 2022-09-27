package codetophuawei;

import java.util.Stack;

/*给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
示例 1：
输入：s = "1 + 1"
输出：2
示例 2：
输入：s = " 2-1 + 2 "
输出：3
示例 3：
输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
提示：
1 <= s.length <= 3 * 105
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式
'+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
'-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
输入中不存在两个连续的操作符
每个数字和运行的计算将适合于一个有符号的 32位 整数
*/
public class Test224 {
    public int calculate(String s) {
        int n = s.length();
        //初始化符号为1
        int sigh = 1;
        //存放符号用的
        Stack<Integer> stack = new Stack<>();
        //向栈中添加1，表示正号
        stack.push(1);
        //结果
        int res = 0;
        //遍历字符串
        for (int i = 0; i < n; ) {
            //拿到当前字符串
            char cur = s.charAt(i);
            //如果当前字符是' ',指针向后移动一位
            if (cur == ' ') {
                i++;
            }
            //当前字符是'('，将符号位压入栈中，指针向右移动一位
            else if (cur == '(') {
                stack.push(sigh);
                i++;
            }
            //当前字符是')',将符号位弹出，指针向右移动一位
            else if (cur == ')') {
                stack.pop();
                i++;
            }
            //如果当前符号是'+',就拿到栈顶元素，指针向后移动一位
            else if (cur == '+') {
                sigh = stack.peek();
                i++;
            }
            //如果当前符号是'-',就拿到栈顶元素取相反数，指针向后移动一位
            else if (cur == '-') {
                sigh = -stack.peek();
                i++;
            }
            //记录当前数字
            else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                //带上符号，累加到和中
                res += sigh * num;
            }
        }
        //返回最终结果
        return res;
    }
}


class Solution120 {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        //将正号放入栈中
        stack.push(1);
        int sign = 1;
        int res = 0;
        int i = 0;
        while (i < n) {
            //获取当前字符
            char ch = s.charAt(i);
            //当遍历到空格时，指针i向后指向一位
            if (ch == ' ') {
                i++;
            } else if (ch == '(') {
                stack.push(sign);
                i++;
            } else if (ch == ')') {
                stack.pop();
                i++;
            } else if (ch == '+') {
                sign = stack.peek();
                i++;
            } else if (ch == '-') {
                sign = -stack.peek();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }
}