package Leetcode;

import java.util.Arrays;

/*小力将 N 个零件的报价存于数组 nums。小力预算为 target，
假定小力仅购买两个零件，要求购买零件的花费不超过预算，
请问他有多少种采购方案。
注意：答案需要以 1e9 + 7 (1000000007) 为底取模，
如：计算初始结果为：1000000008，请返回 1
*/
public class Test52 {
    public int purchasePlans(int[] nums, int target) {
        int n=nums.length;
        //先对数组排序
        Arrays.sort(nums);
        //双指针
        //一个指针指向数组的开头
        int i=0;
        //另一个指针指向数组的末尾
        int j=n-1;
        //记录不超过预算的组合数
        int count=0;
        while (i<j){
            //计算此时两个数字的和
            int sum=nums[i]+nums[j];
            //当此时的；两数之和大于target此时将指针j向左移动
            if(sum>target){
                j--;
            }
            //当前两数之和小于等于target,将结果累加
            //由于j位置的数字较大，此时这对组合都满足这个和那么
            //i与j之间的数字一定都满足小于等于target,将累加组合数量为j-i个
            else {
                count=(count+(j-i))%1000000007;
                //将i指针向后指，扩大当前的两数之和
                i++;
            }
        }
        //返回最后的结果
        return count;
    }
}
