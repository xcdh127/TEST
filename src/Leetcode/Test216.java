package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*给你两个整数数组 startTime（开始时间）和 endTime（结束时间），
并指定一个整数 queryTime 作为查询时间。
已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，
返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
*/
/*输入：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
输出：1
解释：一共有 3 名学生。
第一名学生在时间 1 开始写作业，并于时间 3 完成作业，在时间 4 没有处于做作业的状态。
第二名学生在时间 2 开始写作业，并于时间 2 完成作业，在时间 4 没有处于做作业的状态。
第三名学生在时间 3 开始写作业，预计于时间 7 完成作业，这是是唯一一名在时间 4 时正在做作业的学生。
*/
public class Test216 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n=startTime.length;
        int[][] arr=new int[n][2];
        //将学生开始写作业和停止写作业的时间记录在数组中
        for (int i = 0; i < n; i++) {
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
        }
        //统计在写作业的学生
        int count=0;
        for (int i = 0; i < n; i++) {
            //查询时间在开始和结束之间计数+1
            if (queryTime<=arr[i][1] && queryTime>=arr[i][0]){
                count++;
            }
        }
        //返回学生人数
        return count;
    }
}
