package codetophuawei;

import java.util.Stack;

/*给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
示例 1:
输入: "3+2*2"
输出: 7
示例 2:
输入: " 3/2 "
输出: 1
示例 3:
输入: " 3+5 / 2 "
输出: 5
说明：
你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
*/
public class Test16_26 {
    //全局指针
    int i = 0;

    public int calculate(String s) {
        int n = s.length();
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        //当全局指针没有指向字符串末尾时，继续向后指向
        while (i < n) {
            char ch = s.charAt(i);
            //拿到的是数字
            if (i < n && Character.isDigit(ch)) {
                //拿到当前数字
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                //如果字符符号是+号，直接放进栈中
                if (sign == '+') {
                    stack.push(num);
                }
                //当前字符是-号，相反数放进栈中
                else if (sign == '-') {
                    stack.push(-num);
                }
                //当前字符是*号，弹出栈顶数字与当前数字相乘
                else if (sign == '*') {
                    int prev = stack.pop();
                    stack.push(prev * num);
                }
                //当前字符是/号，弹出栈顶数字与当前数字相除
                else if (sign == '/') {
                    int prev = stack.pop();
                    stack.push(prev / num);
                }
            }
            //当遇到的是空格时，就向后指向
            else if (ch == ' ') {
                i++;
            }
            //遇到加号，改变符号
            else if (ch == '+') {
                sign = '+';
                i++;
            }
            //遇到减号，改变符号
            else if (ch == '-') {
                sign = '-';
                i++;
            }
            //遇到乘号，改变符号
            else if (ch == '*') {
                sign = '*';
                i++;
            }
            //遇到除号，改变符号
            else if (ch == '/') {
                sign = '/';
                i++;
            }
        }
        int sum = 0;
        //弹出栈中元素，累加求和
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}

class Solution128 {
    int index;

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();

        int n = s.length();

        char sign = '+';

        while (index < n) {

            if (index < n && Character.isDigit(s.charAt(index))) {

                String numStr = getNum(s, index);
                int num = Integer.valueOf(numStr);
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {

                    stack.push(-num);
                } else if (sign == '*') {

                    int res = stack.pop() * num;
                    stack.push(res);
                } else if (sign == '/') {

                    int res = stack.pop() / num;
                    stack.push(res);
                }
            } else if (index < n && s.charAt(index) == '+' || s.charAt(index) == '-' || s.charAt(index) == '*' || s.charAt(index) == '/') {
                sign = s.charAt(index);
                index++;
            } else if (index < n && s.charAt(index) == ' ') {
                index++;
            }
        }
        int ret = 0;
        while (!stack.isEmpty()) {

            ret += stack.pop();

        }
        return ret;
    }

    public String getNum(String s, int i) {

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            index++;
        }
        return s.substring(i, index);
    }

}

