package CodeTop02;

/*给定一个大小为 n 的数组 nums ，返回其中的多数元素。
多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1：
输入：nums = [3,2,3]
输出：3
示例 2：
输入：nums = [2,2,1,1,1,2,2]
输出：2
提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
*/
public class Test169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        //摩尔投票
        int major = 0;
        //记录票数
        int vote = 0;
        //遍历数组
        for (int num : nums) {
            //当票数为0时，大多数元素是num
            if (vote == 0) {
                major = num;
            }
            //当前数字不是多数元素时，投票数-1
            if (num != major) {
                vote--;
            }
            //当前数字是多数元素时，投票数+1
            else {
                vote++;
            }
        }
        return major;
    }
}

class Solution83 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int major = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                major = num;
            }
            if (major == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return major;
    }
}
