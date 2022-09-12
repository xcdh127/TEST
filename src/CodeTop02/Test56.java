package CodeTop02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
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
        //按照区间初始位置排序
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n) {
            //记录i位置的始末区间值
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};
            //指针指向i的下一个位置
            int j = i + 1;
            //如果i位置的末尾区间位置大于等于开始区间位置时，开始合并区间
            while (j < n && temp[1] >= intervals[j][0]) {
                temp[1] = Math.max(intervals[j][1], temp[1]);
                j++;
            }
            //将合并好的区间添加到结果数组中
            res.add(temp);
            //i位置指向j位置
            i = j;
        }
        //返回结果
        return res.toArray(new int[0][]);
    }
}
