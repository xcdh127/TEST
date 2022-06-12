package Test;

import java.util.PriorityQueue;

/*写一个 RecentCounter 类来计算特定时间范围内最近的请求。
请你实现 RecentCounter 类：
RecentCounter() 初始化计数器，请求数为 0 。
int ping(int t) 在时间 t 添加一个新请求，
其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数
（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
保证 每次对 ping 的调用都使用比之前更大的 t 值。
*/
public class RecentCounter {
    //初始化优先队列
    PriorityQueue<Integer> queue;
    public RecentCounter() {
        queue=new PriorityQueue<>();

    }

    public int ping(int t) {
        //当队列不为空时，将判断队列中最小的请求数是否小于t-3000
        //如果小于就将该请求弹出
        while(!queue.isEmpty() && queue.peek()<t-3000){
            queue.poll();
        }
        //将当前请求添加到队列中
        queue.offer(t);
        //返回当前队列中请求的个数
        return queue.size();
    }
}
