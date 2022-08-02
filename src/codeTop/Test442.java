package codeTop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
且每个整数出现 一次 或 两次 。
请你找出所有出现 两次 的整数，并以数组形式返回。
你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
示例 1：
输入：nums = [4,3,2,7,8,2,3,1]
输出：[2,3]
示例 2：
输入：nums = [1,1,2]
输出：[1]
示例 3：
输入：nums = [1]
输出：[]
提示：
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
nums 中的每个元素出现 一次 或 两次
*/
public class Test442 {
    public List<Integer> findDuplicates(int[] nums) {
        //存放结果
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            //当下标i位置的数字不等于下标为i位置数字-1的数字时
            //交换这两个位置上的数字
            while (nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        //遍历数组
        for (int i = 0; i < n; i++) {
            //当i位置的数字不等于i+1时
            if (nums[i]!=i+1){
                //将i位置的数字添加到数组中
                list.add(nums[i]);
            }
        }
        //返回结果
        return list;
    }
    //交换数组中的两个数字
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
class Solution40 {
    public static List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i+1){
                list.add(nums[i]);
            }
        }
        return list;
    }
    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}