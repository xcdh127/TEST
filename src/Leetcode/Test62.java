package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*给你一个数组 nums，请你从中抽取一个子序列，
满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
如果存在多个解决方案，只需返回 长度最小 的子序列。
如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，
也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
*/
public class Test62 {
    public List<Integer> minSubsequence(int[] nums) {
        //先对数组进行排序
        Arrays.sort(nums);
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        //求数组的总和
        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        //从后向前遍历数组
        //求数组从最后连续和
        int sumLast=0;
        for (int i = n-1; i >=0; i--) {
            //子数组求和
            sumLast+=nums[i];
            //数组总减去子数组中的元素
            sum-=nums[i];
            //将数组中的当前数字放进list中
            list.add(nums[i]);
            //如果子数组的和大于其他部分的时将跳出循环
            if (sumLast>sum){
                break;
            }
        }
        //返回list
        return list;
    }
}
