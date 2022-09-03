package Jianzhioffer02;

import java.util.Stack;

public class Test09 {

}

/*用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )
示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：
1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
*/
class CQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    //栈A作为队列末尾
    public void appendTail(int value) {
        stackA.push(value);

    }

    //栈B作为队列的头
    public int deleteHead() {
        //当队列的头部不为空时，返回栈B的栈顶元素
        if (!stackB.isEmpty()) {
            return stackB.pop();
        }
        //当队列头部为空时，将队列末尾元素放到队列的头部
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        //当队列的头部为空时，返回-1
        if (stackB.isEmpty()) {
            return -1;
        }
        //弹出队列头部的元素
        return stackB.pop();
    }
}
