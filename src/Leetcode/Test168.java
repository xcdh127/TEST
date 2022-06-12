package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*给你一个二维整数数组 ranges 和两个整数 left 和 right 。
每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
*/
/*输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
输出：true
解释：2 到 5 的每个整数都被覆盖了：
- 2 被第一个区间覆盖。
- 3 和 4 被第二个区间覆盖。
- 5 被第三个区间覆盖。
*/
public class Test168 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set=new HashSet<>();
        //将数组按照时间先后排序,将此数组中的所有覆盖的数字放进set中
        Arrays.sort(ranges,(a,b)->(a[0]-b[0]));
        //遍历二维数组中的全部数组
        for (int[] range :ranges) {
            int start=range[0];
            int end=range[1];
            //将数组区间的数字全部添加到set中
            for (int i = start; i <=end ; i++) {
                set.add(i);
            }
        }
        //遍历数字从left到right，判断set集合中是否存在所有数字
        for (int i = left; i <=right ; i++) {
            //如果区间中有一个数字没有覆盖，则返回错误
            if (!set.contains(i)){
                return false;
            }
        }
        //全员覆盖，返回true
        return true;
    }
}
