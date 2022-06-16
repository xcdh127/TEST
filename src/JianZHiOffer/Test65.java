package JianZHiOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
示例 1：
输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：
输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 
限制：
1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5
*/
public class Test65 {
}
class MaxQueue {
    Queue<Integer> queue1;
    Deque<Integer> queue2;

    public MaxQueue() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public int max_value() {
        if (queue2.isEmpty()) {
            return -1;
        }
        return queue2.getFirst();
    }

    public void push_back(int value) {
        queue1.offer(value);
        while (!queue2.isEmpty() && queue2.peekLast()<value){
            queue2.pollLast();
        }
        queue2.offerLast(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()) {
            return -1;
        }
        int poll = queue1.poll();
        if (queue2.peekFirst()==poll){
            queue2.pollFirst();
        }
        return poll;
    }
}