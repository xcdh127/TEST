package codetophuawei;

import java.util.List;

/*给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
示例 1：
输入：timePoints = ["23:59","00:00"]
输出：1
示例 2：
输入：timePoints = ["00:00","23:59","00:00"]
输出：0
提示：
2 <= timePoints.length <= 2 * 104
timePoints[i] 格式为 "HH:MM"
*/
public class Test539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] arr = new boolean[1440];
        int n = timePoints.size();
        for (int i = 0; i < n; i++) {
            String[] strArr = timePoints.get(i).split(":");
            int hour = Integer.parseInt(strArr[0]);
            int min = Integer.parseInt(strArr[1]);
            int count = hour * 60 + min;
            if (arr[count]) {
                return 0;
            }
            arr[count] = true;
        }
        int min = 1440;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        //遍历1440分钟，找出其中差值最小的时间间隔
        for (int i = 0; i < 1440; i++) {
            //当i位置的时间存在时，才统计前面位置和最大位置，以及统计最小时间差值
            if (arr[i]) {
                if (i < min) {
                    min = i;
                }
                if (prev != -1) {
                    minDiff = Math.min(minDiff, i - prev);
                }
                //前一个位置指向i位置
                prev = i;
            }
        }
        //记录下最小时间+一天之后的时间-max，和最小差值的最小值
        return Math.min(min + 1440 - prev, minDiff);
    }
}

class Solution101 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] arr = new boolean[1440];
        for (String timePoint : timePoints) {
            String[] str = timePoint.split(":");
            int num1 = Integer.valueOf(str[0]) * 60;
            int num2 = Integer.valueOf(str[1]);
            if (arr[num1 + num2]) return 0;
            arr[num1 + num2] = true;
        }
        int first = 1440;
        int last = 0;
        int prev = -1;
        int minDiff = 1440;
        for (int i = 0; i < 1440; i++) {
            if (arr[i]) {
                if (first > i) {
                    first = i;
                }
                if (prev != -1) {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
                last = i;
            }
        }
        minDiff = Math.min(minDiff, (first + 1440) - last);
        return minDiff;
    }
}