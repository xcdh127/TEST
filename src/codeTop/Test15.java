package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：
输入：nums = []
输出：[]
示例 3：
输入：nums = [0]
输出：[]
提示：
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        int i=0;
        List<List<Integer>> res=new ArrayList<>();
        //对数组进行排序
        Arrays.sort(nums);
        //当i小于n-2时
        while (i<n-2){
            int j=i+1;
            int k=n-1;
            while (j<k){
                //当和为0时，将当前的数字添加到res中
                if (nums[i]+nums[j]+nums[k]==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    //去掉重复的三元组
                    int temp=nums[j];
                    while (temp==nums[j] && j<k){
                        j++;
                    }
                }
                //和小于0时，j++，使得和变大
                else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                //和大于0时，k--，使得和变小
                else {
                    k--;
                }
            }
            //去掉重复三元组
            int temp=nums[i];
            while (i<n-2 && temp==nums[i]){
                i++;
            }
        }
        //返回结果
        return res;
    }
}
