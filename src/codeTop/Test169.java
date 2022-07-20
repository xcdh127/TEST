package codeTop;
/*给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例1：
输入：nums = [3,2,3]
输出：3
示例2：
输入：nums = [2,2,1,1,1,2,2]
输出：2
提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问
*/
public class Test169 {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        //多数元素
        int major=0;
        //投票数量
        int vote=0;
        for (int num :nums) {
            //当票数为0时，更新多数数字
            if (vote==0){
                major=num;
            }
            //当major等于多数数字时，投票+1
            if (major==num){
                vote++;
            }
            //当major不等于多数数字时，投票-1
            else {
                vote--;
            }
        }
        //返回多数数字
        return major;
    }
}
