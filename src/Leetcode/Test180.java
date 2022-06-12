package Leetcode;
/*给你一个正整数数组 arr ，
请你计算所有可能的奇数长度子数组的和。
子数组 定义为原数组中的一个连续子序列。
请你返回 arr 中 所有奇数长度子数组的和 。
*/
/*输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
*/
public class Test180 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        //记录前缀和
        int[] pre=new int[n+1];
        pre[0]=0;
        for (int i = 1; i <=n ; i++) {
            pre[i]=pre[i-1]+arr[i-1];
        }
        //记录奇数长度子数组的和
        int count=0;
        for (int i = 0; i <= n; i++) {
            //步长为2，取出奇数长度的子数组和
            for (int j = i+1; j <= n; j+=2) {
                count+=pre[j]-pre[i];
            }
        }
        //返回结果
        return count;
    }
}
