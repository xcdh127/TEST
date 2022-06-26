package JianZHiOffer;
/*给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树
有多少种？返回满足题意的二叉搜索树的种数。
示例 1：
输入：n = 3
输出：5
示例 2：
输入：n = 1
输出：1
提示：
1 <= n <= 19
*/
public class Test51 {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        //由0个节点组成的二叉树的种数
        dp[0]=1;
        //由1个节点组成的二叉树的种数
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                //当前节点左侧节点个数 乘 当前节点右侧节点个数
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
/*class Solution {
    public int numTrees(int n) {
			int[] dp=new int[n+1];
			//空树组成的二叉搜索树的种类
			dp[0]=1;
			//二叉搜索树只有一个节点时的二叉树的种类数
			dp[1]=1;
			for(int i=2;i<=n;i++){
				for(int j=1;j<=i;j++){
					//当前节点左侧的节点个数，当前节点右侧的节点个数
					//累加起来得当前节点长度的二叉树种类数；
					dp[i]+=dp[j-1]*dp[i-j];
				}
			}
			return dp[n];
    }
}*/