package codetophuawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*给你一个以字符串表示的非负整数 num 和一个整数 k ，
移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
示例 1 ：
输入：num = "1432219", k = 3
输出："1219"
解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
示例 2 ：
输入：num = "10200", k = 1
输出："200"
解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 ：
输入：num = "10", k = 2
输出："0"
解释：从原数字移除所有的数字，剩余为空就是 0 。
提示：
1 <= k <= num.length <= 105
num 仅由若干位数字（0 - 9）组成
除了 0 本身之外，num 不含任何前导零
*/
public class Test402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char number = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > number) {
                stack.pop();
                k--;
            }
            stack.push(number);
        }
        //当没有删够k个字符时，继续删除
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        //遇0标志位，见到0，变为false
        boolean zero = true;
        //新建栈1
        Stack<Character> stack1 = new Stack();
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        //栈1不为空时
        while (!stack1.isEmpty()) {
            char number = stack1.pop();
            //去除前导0
            if (zero && number == '0') {
                continue;
            }
            //非前导0，就将标志位置为false
            zero = false;
            sb.append(number);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}


class Solution161 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char number = num.charAt(i);
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > number) {
                queue.removeLast();
                k--;
            }
            queue.addLast(number);
        }

        for (int i = 0; i < k; i++) {
            queue.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        while (!queue.isEmpty()) {
            char number = queue.removeFirst();
            if (zero && number == '0') {
                continue;
            }
            zero = false;
            sb.append(number);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}