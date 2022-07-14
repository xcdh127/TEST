package codeTop;
/*给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
示例 1:
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例2:
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
提示：
你可以假设 nums中的所有元素是不重复的。
n将在[1, 10000]之间。
nums的每个元素都将在[-9999, 9999]之间。
*/
public class Test704 {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        while (i<=j){
            //取中点
            int m=i+(j-i)/2;
            //中点值等于目标值，返回下标m
            if (nums[m]==target){
                return m;
            }
            //中点值大于目标值，说明目标值在数组的前半部分
            else if (nums[m] > target) {
                j=m-1;
            }
            //否则搜索数组的后半部分
            else {
                i=m+1;
            }
        }
        //没有搜索到目标值，返回-1
        return -1;
    }
}
