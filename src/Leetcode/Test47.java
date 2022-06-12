package Leetcode;

import java.util.Arrays;

/*给定一个会议时间安排的数组 intervals
，每个会议时间都会包括开始和结束的时间
intervals[i] = [starti, endi] ，
请你判断一个人是否能够参加这里面的全部会议。
*/
public class Test47 {
    public boolean canAttendMeetings(int[][] intervals) {
        //对会议室按照开始时间排序
        //逐个检查相邻会议的结束时间是否大于下一个开始时间
        int n=intervals.length;
        if (n==0)return true;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        //取出第一个结束会议的时间
        int prevEnd=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果前一个会议是室结束的时间大于下一个开始的时间就不行
            if (prevEnd>intervals[i][0]){
                return false;
            }
            //记录前一个刚刚结束的会议的时间
            prevEnd=intervals[i][1];
        }
        return true;
    }
}
