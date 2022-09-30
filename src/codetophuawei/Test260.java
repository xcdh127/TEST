package codetophuawei;

/*给你一个整数数组 nums，其中恰好有两个元素只出现一次，
其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
示例 1：
输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5, 3] 也是有效的答案。
示例 2：
输入：nums = [-1,0]
输出：[-1,0]
示例 3：
输入：nums = [0,1]
输出：[1,0]
提示：
2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
除两个只出现一次的整数外，nums 中的其他数字都出现两次
*/
public class Test260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = num ^ xor;
        }
        int m = 1;
        //找到第一个异或值为1的位置
        while ((xor & m) == 0) {
            m <<= 1;
        }
        int xorA = 0;
        int xorB = 0;
        for (int num : nums) {
            //数组中的数字分组，两个不同的数字分属于不同组
            //当num&m等于0时，分为一组
            if ((num & m) == 0) {
                xorA ^= num;
            }
            //num&m不等于0时，分为一组
            else {
                xorB ^= num;
            }
        }
        //返回这两个数字
        return new int[]{xorA, xorB};
    }
}


class Solution159 {
    public int[] singleNumber(int[] nums) {


        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int m = 1;
        while ((xor & m) == 0) {
            m <<= 1;
        }
        int xorA = 0;
        int xorB = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                xorA ^= num;
            } else {
                xorB ^= num;
            }
        }
        return new int[]{xorA, xorB};
    }
}