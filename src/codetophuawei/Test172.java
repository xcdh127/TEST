package codetophuawei;

/*给定一个整数 n ，返回 n! 结果中尾随零的数量。
提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
示例 1：
输入：n = 3
输出：0
解释：3! = 6 ，不含尾随 0
示例 2：
输入：n = 5
输出：1
解释：5! = 120 ，有一个尾随 0
示例 3：
输入：n = 0
输出：0
提示：
0 <= n <= 104
进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
*/
public class Test172 {
    public int trailingZeroes(int n) {
        int count = 0;
        //当数字大于5时
        while (n >= 5) {
            //计算数字含有多少个5
            n = n / 5;
            //累加包含5的个数
            count += n;
        }
        //最后阶乘中的0的个数
        return count;
    }
}


class Solution144 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}