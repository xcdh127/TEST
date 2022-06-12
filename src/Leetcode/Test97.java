package Leetcode;
/*给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场
如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
按 总出勤 计，学生缺勤（'A'）严格 少于两天。
学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
*/
public class Test97 {
    public boolean checkRecord(String s) {
        //连续迟到天数
        int chiDao=0;
        //连续缺勤天数
        int queQin=0;
        int n=s.length();
        int i=0;
        //遍历字符串
        while (i<n){
            //如果当前是迟到
            if (s.charAt(i)=='L'){
                //记录当前连续迟到的天数
                int count=0;
                while (i<n && s.charAt(i)=='L'){
                    count++;
                    i++;
                }
                //记录所有迟到连续天数最大值
                chiDao=Math.max(chiDao,count);
            }
            //记录缺勤天数
            else if (s.charAt(i)=='A'){
                queQin++;
                i++;
            }
            //到场向后遍历字符串
            else {
                i++;
            }
        }
        //返回结果
        return queQin<2 && chiDao<3;
    }
}
