package codeTop;

import java.lang.reflect.Array;
import java.util.Arrays;

/*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为O(n) 的算法解决此问题。
示例 1：
输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：
输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
提示：
0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
public class Test128 {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if (n==0){
            return 0;
        }
        int[] dp=new int[n];
        //对数组进行排序
        Arrays.sort(nums);
        //初始化最长递增序列的长度为1
        dp[0]=1;
        //遍历数组，当前位置数字等于后面一位数字+1时，此时连续数组的长度等于dp[i-1]+1
        for (int i = 1; i < n; i++) {
            //当i位置的数字等于j位置的数字+1时，此时数字是连续的，连续数字长度+1
            if (nums[i] == nums[i-1] + 1) {
                dp[i] = dp[i - 1] + 1;
            }
            //当i位置的元素和j位置的元素相等时,此时连续数字长度保持
            else if (nums[i] == nums[i-1]) {
                dp[i] = dp[i - 1];
            }
            //当前i位置的元素小于j位置的元素时,此时连续数字的长度为1
            else {
                dp[i] = 1;
            }
        }
        //记录最大长度
        int max=0;
        for (int num :dp) {
            max=Math.max(num,max);
        }
        return max;
    }
}
