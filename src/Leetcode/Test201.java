package Leetcode;
/*有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。
返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
*/
public class Test201 {
    public int[] fraction(int[] cont) {
        //分母
        int fenMu=1;
        //分子
        int fenZi=cont[cont.length-1];
        for (int i = cont.length-2; i >=0 ; i--) {
            //一进入循环就调换分子和分母
            int temp=fenMu;
            fenMu=fenZi;
            fenZi=temp;
            //重新计算分子
            fenZi+=cont[i]*fenMu;
        }
        return new int[]{fenZi,fenMu};
    }
}
/*class Solution {
    public int[] fraction(int[] cont) {
        // 分母
        int bot = 1;
        // 分子
        int top = cont[cont.length-1];
        for (int i = cont.length-2; i >= 0; i--) {
            // 一进循环就调换分子和分母
            int temp = bot;
            bot = top;
            top = temp;
            // 重新计算分子
            top += cont[i]*bot;
        }
        return new int[] {top, bot};
    }
}
*/