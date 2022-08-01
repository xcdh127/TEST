package codeTop;

import java.util.List;
/*给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标
相同或者等于 上一层结点下标 +
1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：
输入：triangle = [[-10]]
输出：-10
提示：
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
进阶：
你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
*/
public class Test120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        //dp数组
        int[][] dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        //从第一行向后遍历
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                //最左边一列，只能拿到上边的数字
                if (j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }
                //最右边一列，只能拿到左上角的数字
                else if (j==i){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }
                //其他位置，去上方数字和左上方数字的最小值
                else {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }
        //记录最小路径和
        int min=Integer.MAX_VALUE;
        //最后一层数字中找min
        for (int num :dp[n-1]) {
            min=Math.min(num,min);
        }
        //返回最小值
        return min;
    }
}
class Solution31 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        //第一行数字最小和
        dp[0][0]=triangle.get(0).get(0);
        //下面各行的数字最小和
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }
                else if(j==i){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int num : dp[n-1]){
            min=Math.min(num,min);
        }
        return min;
    }
}