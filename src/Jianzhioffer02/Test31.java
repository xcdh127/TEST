package Jianzhioffer02;

import java.util.Stack;

/*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
提示：
0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed 是 popped 的排列。
*/
public class Test31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            //首先向栈中压入当前数字
            stack.push(pushed[i]);
            //当栈不为空时，并且栈顶元素等于弹出序列中的元素
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                //弹出栈顶元素
                stack.pop();
                //出栈指针向后移动
                index++;
            }
        }
        //返回栈是否为空
        return stack.isEmpty();
    }
}

class Solution48 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int index = 0;
        for (int num : pushed) {
            //压栈
            stack.push(num);
            //当栈不为空，并且栈顶元素等于弹出序列的当前数字，弹出当前元素，并且指向弹出序列的下一个数字的位置
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        //判断栈是否为空
        return stack.isEmpty();
    }
}