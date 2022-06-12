package Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。
实现 MaxStack 类：
MaxStack() 初始化栈对象
void push(int x) 将元素 x 压入栈中。
int pop() 移除栈顶元素并返回这个元素。
int top() 返回栈顶元素，无需移除。
int peekMax() 检索并返回栈中最大元素，无需移除。
int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。
*/
public class Test36 {
}
class MaxStack {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    public MaxStack() {
        //普通栈
        stackA=new Stack<>();
        //最大栈
        stackB=new Stack<>();
    }

    public void push(int x) {
        //获取当前栈中的最大值，如果x比最大栈中的元素大，x就是最大值
        int max=stackB.isEmpty()?x:stackB.peek();
        //将x添加到栈A中
        stackA.push(x);
        //将最大值放进最大栈中
        stackB.push(max>x?max:x);
    }

    public int pop() {
        //分别弹出两个栈的栈顶元素
        int num=stackA.pop();
        stackB.pop();
        return num;
    }

    public int top() {
        //返回原栈栈顶元素
        return stackA.peek();
    }

    public int peekMax() {
        //返回最大栈的栈顶的元素
        return stackB.peek();
    }

    public int popMax() {
        //获取最大栈顶的元素
        int max=peekMax();
        //临时栈
        Stack<Integer> stackTemp=new Stack<>();
        //当前栈顶元素不是最大值时，就将原栈中的元素弹出到辅助栈中
        while (top()!=max) stackTemp.push(pop());
        //弹出最大值
        pop();
        //当临时栈不为空时，就将辅助栈中的元素放进原栈中
        while (!stackTemp.isEmpty()){
            push(stackTemp.pop());
        }
        //返回最大值
        return max;
    }
}

/*class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
*/