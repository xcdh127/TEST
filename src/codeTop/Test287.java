package codeTop;

/*给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），
可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
示例 1：
输入：nums = [1,3,4,2,2]
输出：2
示例 2：
输入：nums = [3,1,3,4,2]
输出：3
提示：
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
进阶：
如何证明 nums 中至少存在一个重复的数字?
你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
*/
public class Test287 {
    public int findDuplicate(int[] nums) {
        //慢指针
        int slow = 0;
        //快指针
        int fast = 0;
        //慢指针走一步
        slow=nums[slow];
        //快指针走两步
        fast=nums[nums[fast]];
        //当slow不等于fast时
        while (slow != fast) {
            //慢指针走一步
            slow=nums[slow];
            //快指针走两步
            fast=nums[nums[fast]];
        }
        //慢指针回到原点
        slow=0;
        //当slow不等于fast时
        while (slow!=fast){
            //慢指针走一步
            slow=nums[slow];
            //快指针走一步
            fast=nums[fast];
        }
        //返回慢指针
        return slow;
    }
}

class Solution30 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }
}