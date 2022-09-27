package codetophuawei;

/*
给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
示例 1：
输入：n = 3
输出：3
示例 2：
输入：n = 11
输出：0
解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
提示：
1 <= n <= 231 - 1。
*/
public class Test400 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
    }

    public static int findNthDigit1(int n) {
        int digit = 1;
        long count = 9;
        long start = 1;
        while (n - count > 0) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * start * digit;
        }
        //数字个数-1 / 当前数位，是求第几个数字
        long num = (n - 1) / digit + start;
        String str = String.valueOf(num);
        // 数字个数-1 % 当前数位，是求第几个数位
        return str.charAt((n - 1) % digit) - '0';
    }


    public static int findNthDigit(int n) {
        //基数
        long start = 1;
        //几位数
        int digit = 1;
        //第几个数字
        long count = 9;
        //当前数字大于当前基数时
        while (n - count > 0) {
            n -= count;
            //几位数+1
            digit++;
            //基数*10
            start *= 10;
            //更新数字的个数
            count = 9 * digit * start;
        }
        //计算是哪个数字
        long num = (n - 1) / digit + start;
        //将数字转成字符串
        String str = String.valueOf(num);
        //输出数字的第几个数位
        return str.charAt((n - 1) % digit) - '0';
    }
}


class Solution110 {
    public int findNthDigit(int n) {

        long start = 1;
        int digit = 1;
        long count = 9;
        while (n - count > 0) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * digit * start;
        }
        long num = (n - 1) / digit + start;
        String str = String.valueOf(num);
        return str.charAt((n - 1) % digit) - '0';

    }
}