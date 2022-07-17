package HOT100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
你需要计算完成所有任务所需要的 最短时间 。
示例 1：
输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
示例 2：
输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类
示例 3：
输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
输出：16
解释：一种可能的解决方案是：
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
提示：
1 <= task.length <= 104
tasks[i] 是大写英文字母
n 的取值范围为 [0, 100]
*/
public class Test621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            //统计所有的任务数和任务的出现次数
            Map<Character,Integer> map=new HashMap<>();
            for(char ch : tasks){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            //总任务数
            int size=map.size();
            //统计任务最早可以执行的时间
            List<Integer> nextValuelist=new ArrayList<>();
            //当前剩余任务数
            List<Integer> rest=new ArrayList<>();
            //当前任务最早执行的时间和剩余任务数的初值
            for (Map.Entry<Character,Integer> entry:map.entrySet()){
                //当前任务最近最早可以执行的时间
                nextValuelist.add(1);
                //当前种类的任务还剩余任务数量
                rest.add(entry.getValue());
            }
            int time=0;
            //遍历所有的任务数组
            for (int i = 0; i < tasks.length; i++) {
                time++;
                //获取最近的执行时间
                int minNextValid=Integer.MAX_VALUE;
                //遍历所有剩余的任务
                for(int j=0;j<rest.size();j++){
                    //当前任务还没有执行完
                    if (rest.get(j)!=0){
                        //获取下一个可以执行的最近的一个任务
                        minNextValid=Math.min(minNextValid,nextValuelist.get(j));
                    }
                }
                //将最近可以执行的最小时间与当前时间进行对比,取出较大的时间作为最近的时间
                time=Math.max(time,minNextValid);
                //初始化任务的选择位置
                int best=-1;
                //遍历所有的任务
                for (int j = 0; j < size; j++) {
                    //当前种类的任务还没有执行完毕，并且当前任务的最近可以执行时间是小于当前系统时间的
                    if (rest.get(j)!=0 && nextValuelist.get(j)<=time){
                        //首先选择剩余的任务数较多的任务进行执行
                        if(best==-1 || rest.get(j)>rest.get(best)){
                            best=j;
                        }
                    }
                }
                //更新下一次可以执行的时间
                nextValuelist.set(best,time+n+1);
                //将当种类的剩余任任务数-1
                rest.set(best,rest.get(best)-1);
            }
            return time;
        }
    }
}
/**/
