package codetophuawei;

import com.sun.org.apache.regexp.internal.RE;

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
public class Test57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        //滑动窗口左边界
        int i = 1;
        int sum = 0;
        for (int j = 1; j <= (target + 1) / 2; j++) {
            //进入窗口，和累加右边窗口的数字
            sum += j;
            //当子数组的和大于等于target时，统计和为target的子数组，并且缩小窗口
            while (sum >= target) {
                //如果子数组和等于目标值，将连续数组放进结果集中
                if (sum == target) {
                    int[] arr = new int[j - i + 1];
                    int index = 0;
                    for (int k = i; k <= j; k++) {
                        arr[index++] = k;
                    }
                    res.add(arr);
                }
                //缩小窗口
                sum -= i;
                i++;
            }
        }
        //返回二维数组
        return res.toArray(new int[0][]);
    }
}
