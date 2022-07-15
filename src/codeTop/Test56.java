package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例2：
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
        int n=intervals.length;
        //首先将区间,按照开始时间排序
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> res=new ArrayList<>();
        //区间初始位置为0
        int i=0;
        while (i<n){
            int j=i+1;
            //i位置的区间
            int[] temp=intervals[i];
            //当j<n,并且temp的右端点大于等于当前区间的左端点时,temp右端点取较大者，继续向后遍历j++
            while (j<n && temp[1]>=intervals[j][0]){
                //合并区间
                temp[1]=Math.max(temp[1],intervals[j][1]);
                j++;
            }
            //将j赋值给i
            i=j;
            //将合并后的区间添加到res中
            res.add(temp);
        }
        return res.toArray(new int[0][]);
    }
}
