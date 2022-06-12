package Leetcode;

import java.util.Arrays;

/*给你一个整数数组 salary ，
数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
*/
public class Test44 {
    public double average(int[] salary) {
        //先对数组进行排序
        Arrays.sort(salary);
        //记录和
        double sum=0;
        for (int i = 1; i < salary.length-1; i++) {
            sum+=salary[i];
        }
        //返回平均薪资
        return sum/(salary.length-2);
    }
}
