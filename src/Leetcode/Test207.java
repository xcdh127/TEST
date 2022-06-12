package Leetcode;
/*给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
两个数的 最大公约数 是能够被两个数整除的最大正整数。*/
public class Test207 {
    public static void main(String[] args) {
        System.out.println(gcb(4, 6));
    }
    public static int findGCD(int[] nums) {
        //记录数组中的最小值
        int min=Integer.MAX_VALUE;
        //记录数组中的最小值
        int max=Integer.MIN_VALUE;
        //遍历数组获取最大值和最小值
        for (int num : nums) {
            min=Math.min(num,min);
            max=Math.max(num,max);
        }
        //返回最大公约数
        return gcb(min,max);
    }
    //求取数字a,和数字b的最大公约数
    public static int gcb(int a,int b){
        return a==0?b:gcb(b%a,a);
    }
}
