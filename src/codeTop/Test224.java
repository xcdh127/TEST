package codeTop;

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
        int n=s.length();
        Stack<Integer> stack=new Stack<>();
        //将正号放入栈中
        stack.push(1);
        int sign=1;
        int res=0;
        int i=0;
        while (i<n){
            //获取当前字符
            char ch=s.charAt(i);
            //当遍历到空格时，指针i向后指向一位
            if (ch==' '){
                i++;
            }
            //遇到左括号时，添加sign到栈中，指针向后指向一位
            else if (ch == '(') {
                stack.push(sign);
                i++;
            }
            //遇到右括号时，弹出栈顶的符号位，指针向后指向一位
            else if (ch == ')') {
                stack.pop();
                i++;
            }
            //遇到加号时，获取符号位，指针向后指向一位
            else if (ch == '+') {
                sign=stack.peek();
                i++;
            }
            //遇到减号时，获取符号位，栈顶元素取反，指针向后指向一位
            else if (ch == '-') {
                sign=-stack.peek();
                i++;
            }
            //遇到数字时
            else {
                //记录当前数字
                int num=0;
                //当指针没有指向字符串的末尾时，并且当前字符是数字时
                while (i<n && Character.isDigit(s.charAt(i))){
                    //形成当前数字
                    num=num*10+(s.charAt(i)-'0');
                    //指针向后指向一位
                    i++;
                }
                //结果累加当前数字
                res+=sign*num;
            }
        }
        //返回结果
        return res;
    }
}
class Solution4 {
    public int calculate(String s) {
        //存放符号的stack栈
        int n=s.length();
        Stack<Integer> stack=new Stack<Integer>();
        //先将正号放进栈中
        stack.push(1);
        int sign=1;
        int res=0;
        int i=0;
        while(i<n){

            //当遇到空格时，将指针向后移动一位
            char ch=s.charAt(i);
            if(ch==' '){
                i++;
            }
            else if(ch=='('){

                stack.push(sign);
                i++;
            }
            else if(ch==')'){

                stack.pop();
                i++;
            }
            else if(ch=='+'){
                sign=stack.peek();
                i++;

            }
            else if(ch=='-'){

                sign=-stack.peek();
                i++;
            }
            else{

                int num=0;
                while(i<n && Character.isDigit(s.charAt(i))){

                    num=num*10+(s.charAt(i)-'0');
                    i++;
                }
                res+=sign*num;

            }
        }
        return res;
    }
}

