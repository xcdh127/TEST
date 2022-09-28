package codetophuawei;

/*给你一个整数 n ，请你找出并返回第 n 个 丑数 。
丑数 就是只包含质因数 2、3 和/或 5 的正整数。
示例 1：
输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
示例 2：
输入：n = 1
输出：1
解释：1 通常被视为丑数。
提示：
1 <= n <= 1690
*/
public class Test264 {
    public int nthUglyNumber(int n) {
        //初始化*2，*3，*5的指针位置为0
        int a = 0;
        int b = 0;
        int c = 0;
        //第i个丑数的值为dp[i-1]
        int[] dp = new int[n];
        //第一个丑数的值为1
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            //大丑数是由小丑数乘以2,3,5得来的，每一次取最小的丑数
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            //当前丑数与a指针对应位置丑数*2相等时，指针a向后指向一位
            if (dp[i] == dp[a] * 2) {
                a++;
            }
            //当前丑数与b指针指向位丑数*3相等时，指针b向后指向一位
            if (dp[i] == dp[b] * 3) {
                b++;
            }
            //当前丑数与指针c指向位置丑数*5相等时，指针c向后指向一位
            if (dp[i] == dp[c] * 5) {
                c++;
            }
        }
        //返回第n个丑数的值
        return dp[n - 1];
    }
}

class Solution141 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            if (dp[a] * 2 == dp[i]) {
                a++;
            }
            if (dp[b] * 3 == dp[i]) {
                b++;
            }
            if (dp[c] * 5 == dp[i]) {
                c++;
            }
        }
        return dp[n - 1];
    }
}