package TTT;
/*416. 分割等和子集
给你一个 只包含正整数 的 非空 数组 nums 。
请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。*/
public class Test17 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num : nums){
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        //背包容量
        int target=sum/2;
        boolean[][] dp=new boolean[n+1][target+1];
        //塞满容量为0的背包
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        //
        for(int i=1;i<=n;i++){
            int num=nums[i-1];
            //背包容量从1开始到target
            for(int j=1;j-num>=0;j++){
                //不将第i位置的物品放进背包

                //如果不将i位置物品放进背包不能塞满背包
                //判断背包是否能容纳下第i个物品

                    dp[i][j]=dp[i-1][j-num];

            }
        }
        //n个物品是否能塞满容量为target的背包
        return dp[n][target];
    }
}
