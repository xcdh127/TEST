package codeTop;

import java.util.Stack;

public class TestOffer09 {

}
/*用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
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
        stackA=new Stack<>();
        stackB=new Stack<>();
    }

    public void appendTail(int value) {
        //栈A作为队列的末尾
        stackA.push(value);
    }

    public int deleteHead() {
        //当栈A以及栈B都为空时，返回-1
        if (stackA.isEmpty() && stackB.isEmpty()){
            return -1;
        }
        //当栈B为空时
        if (stackB.isEmpty()){
            //当栈A不为空时
            while (!stackA.isEmpty()){
                //将栈A中的东西全部压到栈B中
                stackB.push(stackA.pop());
            }
        }
        //弹出栈B
        return stackB.pop();
    }
}
