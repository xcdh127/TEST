package JianZHiOffer;
/*给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，
我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：
2 <= n <= 58
*/
public class Test14 {
    public int cuttingRope(int n) {
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <i ; j++) {
                //值为i的数字可以通过拆分成两个数字的乘积，也可以拆分成超过两个数字的乘积
                //1.dp[i-j]*j意思是可以将数字i拆分成j和继续拆分（i-j）
                //2.(i-j)*j直接将数字i拆分成数字i和（i-j）
                //每一次都使用最大值更新dp[i]，最后找出最大值赋值给dp[i]
                dp[i]=Math.max(Math.max(dp[i-j]*j,(i-j)*j),dp[i]);
            }
        }
        int max=0;
        for (int num :dp) {
            max=Math.max(num,max);
        }
        return max;
    }
}

/*class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
*/
