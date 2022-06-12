package Leetcode;
/*给你一个 从 0 开始的排列 nums（下标也从 0 开始）。
请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。
返回构建好的数组 ans 。
从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
*/
/*输入：nums = [0,2,1,5,3,4]
输出：[0,1,2,4,5,3]
解释：数组 ans 构建如下：
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
    = [0,1,2,4,5,3]
*/
public class Test194 {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        //创建一个新数组
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            //将nums数字对应位置的数字放到arr数组中
            arr[i]=nums[nums[i]];
        }
        //返回数组arr
        return arr;
    }
}
