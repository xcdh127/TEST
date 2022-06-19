package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
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
public class Test8 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        int i=0;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        while (i<n-2){
            int j=i+1;
            int k=n-1;
            while (j<k){
                if (nums[i]+nums[j]+nums[k]==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    int temp=nums[j];
                    while (j<k && temp==nums[j]){
                        j++;
                    }
                } else if (nums[i]+nums[j]+nums[k]>0) {
                    k--;
                }
                else {
                    j++;
                }
            }
            int temp=nums[i];
            while (i<n-2 && temp==nums[i]){
                i++;
            }
        }
        return res;
    }
}
