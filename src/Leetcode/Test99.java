package Leetcode;
/*给你一个字符串 date ，它的格式为 Day Month Year ，其中：
Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
"Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
Year 的范围在 ​[1900, 2100] 之间。
请你将字符串转变为 YYYY-MM-DD 的格式，其中：
YYYY 表示 4 位的年份。
MM 表示 2 位的月份。
DD 表示 2 位的天数。
*/
/*输入：date = "20th Oct 2052"
输出："2052-10-20"*/
public class Test99 {
    public String reformatDate(String date) {
        //按照空格分割字符串
        String[] line=date.split(" ");
        //取出年份
        String year=line[2];
        int month=0;
        String[] arr=new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec"};
        //遍历月份数组，找到下标+1
        for (int i = 0; i < arr.length; i++) {
            if (line[1].equals(arr[i])){
                month=i+1;
                break;
            }
        }
        //求出天数
        String day=line[0];
        int num=0;
        int i=0;
        //拼接数字
        while (i<day.length() && Character.isDigit(day.charAt(i))){
            num=num*10+(day.charAt(i)-'0');
            i++;
        }
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //拼接年份
        sb.append(year+"-");
        //拼接月份
        if (month<10){
            sb.append("0"+month+"-");
        }
        else {
            sb.append(month+"-");
        }
        //拼接天
        if (num<10){
            sb.append("0"+num);
        }
        else {
            sb.append(num);
        }
        //输出字符串
        return sb.toString();
    }
}
