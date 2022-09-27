package codetophuawei;

import java.util.Stack;

/*给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
示例 1:
输入: "()"
输出: True
示例 2:
输入: "(*)"
输出: True
示例 3:
输入: "(*))"
输出: True
注意:
字符串大小将在 [1，100] 范围内。
*/
public class Test678 {
    public boolean checkValidString(String s) {
        int n = s.length();
        //存放左括号的栈
        Stack<Integer> left = new Stack<>();
        //存放星号的栈
        Stack<Integer> star = new Stack<>();
        //遍历字符串,存放过程是按照顺序的，后面的右括号可以与前面出现的左括号以及星号匹配
        for (int i = 0; i < n; i++) {
            //遇到左括号，将此时的下标存入到栈中
            if (s.charAt(i) == '(') {
                left.push(i);
            }
            //遇到星号，将此时的坐标存入到栈中
            else if (s.charAt(i) == '*') {
                star.push(i);
            }
            //遇到右括号
            else {
                //如果左括号不为空,弹出一个左括号
                if (!left.isEmpty()) {
                    left.pop();
                }
                //弹出一个星号
                else if (!star.isEmpty()) {
                    star.pop();
                }
                //当左括号和星号都没有时遇到右括号哦，此时返回false
                else {
                    return false;
                }
            }
        }
        //此时右括号已经消耗殆尽，需要判断左括号的数量是否小于等于星号的数量
        while (!left.isEmpty() && !star.isEmpty()) {
            //当星号右边有存在左括号时，此时的左括号就没有匹配的右括号了，返回false
            if (left.pop() > star.pop()) {
                return false;
            }
        }
        //最后存放左括号的栈为空时，就返回true,所有的左括号都有与之匹配的右括号
        return left.isEmpty();
    }


    public boolean checkValidString1(String s) {
        Stack<Integer> left = new Stack<>(), star = new Stack<>(); // index stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == '*') star.push(i);
            else {
                if (!left.isEmpty()) left.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) return false;
        }
        return left.isEmpty();
    }
}




