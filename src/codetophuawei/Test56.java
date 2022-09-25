package codetophuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，
并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
提示：
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/
public class Test56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        //按照初始位置排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        //从下标0开始整合区间
        int i = 0;
        while (i < n) {
            //当前区间
            int[] temp = intervals[i];
            //从后一个位置开始合并区间
            int j = i + 1;
            while (j < n && temp[1] >= intervals[j][0]) {
                temp[1] = Math.max(intervals[j][1], temp[1]);
                j++;
            }
            //将j赋值给i
            i = j;
            //将temp添加到结果中
            res.add(temp);
        }
        //返回结果
        return res.toArray(new int[0][]);
    }
}
