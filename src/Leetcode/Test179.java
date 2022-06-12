package Leetcode;
/*给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
*/
/*输入：nums = [-3,2,-3,4,2]
输出：5
解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
                累加求和
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
*/
public class Test179 {
    public int minStartValue(int[] nums) {
        int n=nums.length;
        //记录前缀和
        int[] pre=new int[n+1];
        pre[0]=0;
        for (int i = 1; i <= n; i++) {
            pre[i]=pre[i-1]+nums[i-1];
        }
        //记录前缀和中最小的数
        int minValue=Integer.MAX_VALUE;
        for (int num :pre) {
            minValue=Math.min(num,minValue);
        }
        //如果前缀和中的最小数字大于等于0，返回1
        if (minValue>=0){
            return 1;
        }
        //否则返回负数绝对值+1
        else {
            return -minValue+1;
        }
    }
}
