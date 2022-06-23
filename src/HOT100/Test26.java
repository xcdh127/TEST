package HOT100;

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
public class Test26 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        //按照开始时间排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            //从当前时间段的后一段时间开始合并区间
            int j = i + 1;
            //当前的时间段
            int[] temp = intervals[i];
            //前一段时间的结束时间大于等于后一段时间的开始时间，此时区间可以合并
            //直到区间没有交集为止
            while (j < n && temp[1] >= intervals[j][0]) {
                temp[1]=Math.max(intervals[j][1],temp[1]);
                j++;
            }
            //将合并后的区间添加到结果中
            list.add(temp);
            //对当前的区间向后找相交的区间
            i = j;
        }
        //list中范型为int[]，此时可以将list转成二维数组
        return list.toArray(new int[0][]);
    }
}

/*class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int i=0;
        Arrays.sort(intervals,(i1,i2)->(i1[0]-i2[0]));
        List<int[]> res=new ArrayList<>();
        while(i<n){
            int j=i+1;
            int[] temp=intervals[i];
            while(j<n && temp[1]>=intervals[j][0]){
                temp[1]=Math.max(intervals[j][1],temp[1]);
                j++;
            }
            res.add(temp);
            i=j;
        }
        return res.toArray(new int[0][]);
    }
}*/