package JianZHiOffer;

import java.util.Stack;

public class Test30 {
}
/*定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min
函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
提示：
各函数的调用总次数不超过 20000 次
*/

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    public MinStack() {
        stackA=new Stack<>();
        stackB=new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (!stackB.isEmpty() && x<=stackB.peek()){
            stackB.push(x);
        }
        else if (stackB.isEmpty()){
            stackB.push(x);
        }
    }

    public void pop() {
        int num=stackA.pop();
        if (stackB.peek()==num){
            stackB.pop();
        }
    }

    public int top() {
        return stackA.peek();
    }

    public int min() {
        return stackB.peek();
    }
}