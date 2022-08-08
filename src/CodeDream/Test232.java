package CodeDream;

import java.util.Stack;

public class Test232 {

}

/*请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
实现 MyQueue 类：
void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
说明：
你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
示例 1：
输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]
解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
提示：
1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
进阶：
你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
*/
class MyQueue {

    //栈A
    Stack<Integer> stackA;
    //栈B
    Stack<Integer> stackB;

    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    //B栈赋值接收数字，向栈中添加数字
    public void push(int x) {
        stackB.push(x);

    }

    //A栈负责弹出数字
    public int pop() {
        //当栈A为空时，栈B中的元素放进栈A中
        if (stackA.isEmpty()) {
            while (!stackB.isEmpty()) {
                stackA.push(stackB.pop());
            }
        }
        //弹出栈A的栈顶元素
        return stackA.pop();
    }

    //A栈负责弹出数字
    public int peek() {
        //当栈A为空时，栈B中的元素放进栈A中
        if (stackA.isEmpty()) {
            while (!stackB.isEmpty()) {
                stackA.push(stackB.pop());
            }
        }
        //返回栈A顶部元素
        return stackA.peek();
    }

    //当栈A和栈B、都为空时，返回栈为空
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}