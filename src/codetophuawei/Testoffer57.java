package codetophuawei;

import java.util.ArrayList;
import java.util.List;

/*输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
限制：
1 <= target <= 10^5
*/
public class Testoffer57 {
    public int[][] findContinuousSequence(int target) {
        //滑动窗口左边界
        int i = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        //滑动窗口右边界
        for (int j = 1; j <= target / 2 + 1; j++) {
            //求此时连续数组的和
            sum += j;
            //当连续数组和大于等于目标值时
            while (sum >= target) {
                //当连续数组和等于目标值时
                if (sum == target) {
                    //将此时窗口内的值添加到结果集合中
                    List<Integer> list = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        list.add(k);
                    }
                    res.add(list.stream().mapToInt(m -> m).toArray());
                }
                //开始缩小窗口，将连续数组和减去左窗口的值
                sum -= i;
                i++;
            }
        }
        //返回结果
        return res.toArray(new int[0][]);
    }
}
