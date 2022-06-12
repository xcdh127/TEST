package Test;
/*给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
*/
public class Test2 {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        //数组求和
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        //sumA+sumB=sum
        //sumA-sumB=target
        //2sumA=sum+target
        //sumA=(sum+target)/2-->塞满容量为sumA的背包的方法数
        int goal=sum+target;
        //数组是否可以被2整除
        if (goal%2!=0){
            return 0;
        }
        //数组的和小于目标值时返回0
        if (Math.abs(sum)<Math.abs(target)){
            return 0;
        }
        goal=goal/2;
        int[][] dp=new int[n+1][goal+1];
        //塞满容量为0的背包的方法数为1
        dp[0][0]=1;
        //遍历所有的物品
        for (int i=1;i<=n;i++){
            int num=nums[i-1];
            //遍历所有容量的背包
            for (int j=0;j<=goal;j++){
                //对于物品i有两种选择：
                //（1）不将当前数字放进背包中
                dp[i][j]=dp[i-1][j];
                //（2）如果当前背包能够容纳下当前数字，将当前数组放进背包中，此时
                //前i个物品塞满容量为j背包的方法数量的基础上累加
                if(j>=num){
                    dp[i][j]+=dp[i-1][j-num];
                }
            }
        }
        //返回前n个物品塞满容量W为goal的背包的方法数
        return dp[n][goal];
    }
}
