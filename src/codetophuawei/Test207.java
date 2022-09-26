package codetophuawei;

import java.util.*;

/*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
示例 1：
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：
输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
提示：
1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
prerequisites[i] 中的所有课程对 互不相同
*/
public class Test207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存放这个课程后面会有几门后修课程
        Map<Integer, List<Integer>> map = new HashMap<>();
        //记录这个课程的入度情况
        Map<Integer, Integer> inDegrees = new HashMap<>();
        //为每一个课程创建放置后置课程的数组
        for (int i = 0; i < numCourses; i++) {
            //为每门课程创建一个乘法
            map.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }
        //记录入度信息
        for (int[] prerequisite : prerequisites) {

            //向后修课程数组中添加课程信息
            map.get(prerequisite[1]).add(prerequisite[0]);
            //更新入度信息
            inDegrees.put(prerequisite[0], inDegrees.getOrDefault(prerequisite[0], 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        //将入度为0的元素放进队列中
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        //排序数组
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            order.add(temp);
            //弹出先行课程，当先行课程弹出队列后，后修课程的入度-1，直到为0，放进队列中
            //当没有入度为0的课程后，就停止
            for (int next : map.get(temp)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        //返回拓扑排序后的数组元素个数是否和课程数量一致
        return order.size() == numCourses;
    }
}


class Solution99 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        //存放所有入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        //初始化所有课程编号
        for (int i = 0; i < numCourses; i++) {
            //为每门课程创建一个乘法
            map.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        //将后修课程放进先修课程的列表中，先修课程的入度每次+1
        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
            inDegree.put(prerequisite[0], inDegree.getOrDefault(prerequisite[0], 0) + 1);
        }
        //将所有入度为0的节点，放进队列中
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }

        }
        //拓扑排序列表
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            //将数字放进拓扑排序列表
            order.add(temp);
            for (int next : map.get(temp)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return order.size() == numCourses;
    }
}
