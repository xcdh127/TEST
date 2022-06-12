package Leetcode;

import java.util.PriorityQueue;

/*有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。
假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
*/
public class Test72 {
    public int lastStoneWeight(int[] stones) {
        //创建最大堆,从大到小存放石块
        //默认是最小堆，此处传进一个比较器，逆序排序
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->(b-a));
        for (int num :stones) {
            queue.offer(num);
        }
        //当优先队列大小大于等于2时
        while (queue.size()>=2){
            //弹出最大的石头
            int maxBig=queue.poll();
            //弹出第二大的石头
            int secondBig=queue.poll();
            //当两块石头重量不一致时，用大块减去小块，将剩余石块放进队列中
            if (maxBig!=secondBig){
                queue.offer(maxBig-secondBig);
            }
        }
        //判断队列是否为空，若为空就返回0，否则返回队列中的唯一值
        return queue.isEmpty()?0:queue.peek();
    }
}
