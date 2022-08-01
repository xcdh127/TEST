package codeTop;

import java.util.PriorityQueue;

/*中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
进阶:
如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
*/
public class Test295 {
}
class MedianFinder {

    //最大堆
    PriorityQueue<Integer> maxHeap;
    //最小堆
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        //最大堆传进比较器
        maxHeap=new PriorityQueue<>((a,b)->(b-a));
        //默认最小堆
        minHeap=new PriorityQueue<>();
    }

    //将元素，先放最小堆，再放最大堆
    public void addNum(int num) {
        //最大堆的大小与最小堆的大小相等时，将数字放进最小堆中
        if (maxHeap.size()==minHeap.size()){
            //先放最大堆
            maxHeap.offer(num);
            //最大堆最大的放进最小堆
            minHeap.offer(maxHeap.poll());
        }
        //最大堆的大小与最小堆的大小不相等时，将数字放进最大堆中
        else {
            //先放最小堆
            minHeap.offer(num);
            //最小堆最小的放进最大堆
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        //当最大堆的大小等于最小堆的大小时
        if (maxHeap.size()==minHeap.size()){
            //返回最大堆和最小堆的堆顶之和/2.0
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        //当最大堆和最小堆的大小不相等时
        else {
            //返回最小堆的堆顶元素/1.0
            return minHeap.peek()/1.0;
        }
    }
}

class MedianFinder1 {


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder1() {

        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>((i1,i2)->(i2-i1));
    }

    public void addNum(int num) {

        if(minHeap.size()==maxHeap.size()){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        else{

            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {

        if(minHeap.size()==maxHeap.size()){

            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        else{

            return minHeap.peek()/1.0;
        }

    }
}