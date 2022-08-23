package CodeDream;

/*给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
示例 1：
输入：n = 3
输出：5
示例 2：
输入：n = 1
输出：1
提示：
1 <= n <= 19
*/
public class Test96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //0个节点二叉搜索树个数
        dp[0] = 1;
        //1个节点二叉搜索树个数
        dp[1] = 1;
        //从2个节点开始到n个节点
        for (int i = 2; i <= n; i++) {
            //统计从第1个节点到第i个节点作为根节点的不同二叉搜索树的个数
            //根节点左右两边的笛卡尔积
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        //返回n个节点的不同二叉搜索树的个数
        return dp[n];
    }
}
