package Leetcode;
/*请你编写一个程序来计算两个日期之间隔了多少天。

日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*示例 1：
输入：date1 = "2019-06-29", date2 = "2019-06-30"
输出：1
示例 2：
输入：date1 = "2020-01-15", date2 = "2019-12-31"
输出：15
*/
public class Test78 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysPassed1971(date1)-daysPassed1971(date2));
    }

    public int daysPassed1971(String date){
        //基础年份的月份距离年开始的天数
        int[] dayPass=new int[]{0,31,59,90,120,151,181,212,243,273,304,334};
        int ans=0;
        String[] d=date.split("-");
        //拿到年份
        int year=Integer.parseInt(d[0]);
        //拿到月份
        int month=Integer.parseInt(d[1]);
        //拿到天
        int day=Integer.parseInt(d[2]);
        for (int i = 1971; i < year; i++) {
            //这里闰年判断不精确，但是通过作差抵消了
            ans+=i%4==0?366:365;
        }
        //统计year年,如果这年时闰年，并且已过2月，天数基础上+1
        if (year<2100 && year%4==0 && month>2){
            ans++;
        }
        //返回总天数
        return ans+dayPass[month-1]+day-1;
    }
}

class Solution11 {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysPassed1971(date1)-daysPassed1971(date2));
    }
    public int daysPassed1971(String date){
        //距离1971年1月1日有多少天
        int dayPass[]=new int[]{0,31,59,90,120,151,181,212,243,273,304,334};
        int ans=0;
        String d[]=date.split("-");
        int year=Integer.parseInt(d[0]);
        int month=Integer.parseInt(d[1]);
        int day=Integer.parseInt(d[2]);
        for(int i=1971;i<year;i++){ans+=i%4==0?366:365;}
        if(year<2100&&year%4==0&&month>2){ans++;}
        return ans+dayPass[month-1]+day-1;
    }
}