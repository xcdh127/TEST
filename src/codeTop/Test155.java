package codeTop;

import java.util.Stack;

public class Test155 {
}
/*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
示例 1:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
输出：
[null,null,null,null,-3,null,0,-2]
解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
提示：
-231 <= val <= 231 - 1
pop、top 和 getMin 操作总是在 非空栈 上调用
push, pop, top, and getMin最多被调用 3 * 104 次
*/
class MinStack {
    //普通栈
    Stack<Integer> stackA;
    //最小栈
    Stack<Integer> stackB;
    public MinStack() {
        stackA=new Stack<>();
        stackB=new Stack<>();
    }
    public void push(int val) {
        //向普通栈中添加元素
        stackA.push(val);
        //当最小栈不为空时，并且最小栈顶元素大于等于val值，或者最小栈为空时
        //将当前元素压入最小栈
        if (!stackB.isEmpty() && stackB.peek()>=val || stackB.isEmpty()){
            stackB.push(val);
        }
    }
    public void pop() {
        //弹出普通栈中的元素
        int num=stackA.pop();
        //最小栈的栈顶元素等于刚刚普通栈弹出的数字时，此时最小栈弹出栈顶元素
        if (stackB.peek()==num){
            stackB.pop();
        }

    }
    public int top() {
        //查看普通栈栈顶元素
        return stackA.peek();

    }
    public int getMin() {
        //查看最小栈栈顶元素
        return stackB.peek();
    }
}