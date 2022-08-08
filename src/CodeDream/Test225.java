package CodeDream;

import java.util.LinkedList;
import java.util.Queue;

public class Test225 {
}

/*请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
实现 MyStack 类：
void push(int x) 将元素 x 压入栈顶。
int pop() 移除并返回栈顶元素。
int top() 返回栈顶元素。
boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
注意：
你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
示例：
输入：
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 2, 2, false]
解释：
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // 返回 2
myStack.pop(); // 返回 2
myStack.empty(); // 返回 False
提示：
1 <= x <= 9
最多调用100 次 push、pop、top 和 empty
每次调用 pop 和 top 都保证栈不为空
进阶：你能否仅用一个队列来实现栈。
*/
class MyStack {
    //队列1
    Queue<Integer> queue1;
    //队列2
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        //向队列2中添加元素，作为栈顶，先出元素
        queue2.offer(x);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //将队列1中的元素压到队列2中
            queue2.offer(queue1.poll());
        }
        //交换两个队列
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    //弹出队列1的队顶元素
    public int pop() {
        return queue1.poll();
    }

    //返回队列1的队顶元素
    public int top() {
        return queue1.peek();
    }

    //返回队列1是否为空
    public boolean empty() {
        return queue1.isEmpty();
    }
}