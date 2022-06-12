package Leetcode;
/*给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，
而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
返回将 current 转化为 correct 需要的 最少操作数 。
*/
/*
输入：current = "02:30", correct = "04:35"
输出：3
解释：
可以按下述 3 步操作将 current 转换为 correct ：
- 为 current 加 60 分钟，current 变为 "03:30" 。
- 为 current 加 60 分钟，current 变为 "04:30" 。
- 为 current 加 5 分钟，current 变为 "04:35" 。
*/
/*current = "02:30", correct = "04:35"*/
public class Test152 {
    public static void main(String[] args) {
        String current="02:30";
        String correct="04:35";
        System.out.println(convertTime(current, correct));

    }
    public static int convertTime(String current, String correct) {
        //记录时间差
        int shiCha=0;
        //记录操作总次数
        int count=0;
        //取出两个时间的小时和分钟
        String[] line= current.split(":");
        int curHour=Integer.parseInt(line[0]);
        int curMinute=Integer.parseInt(line[1]);
        String[] cor=correct.split(":");
        int corHour=Integer.parseInt(cor[0]);
        int corMinute=Integer.parseInt(cor[1]);
        //记录各自距离00：00的分钟数
        int shiJian1=curHour*60+curMinute;
        int shiJian2=corHour*60+corMinute;
        //记录两个时间分钟差
        shiCha=Math.abs(shiJian1-shiJian2);
        //当时间差大于0时
        //为了操作的次数更少，我们只需要将时间按照大的选择，就可以最少的操作次数
        while (shiCha>0){
            while (shiCha>0 && shiCha>=60){
                count++;
                shiCha-=60;
            }
            while (shiCha>0 && shiCha>=15){
                count++;
                shiCha-=15;
            }
            while (shiCha>0 && shiCha>=5){
                count++;
                shiCha-=5;
            }
            while (shiCha>0){
                count++;
                shiCha--;
            }
        }
        //最后返回最少的操作次数
        return count;
    }
}
