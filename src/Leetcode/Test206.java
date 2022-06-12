package Leetcode;
/*一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
注意：在本题中，元素 相同 的不同子集应 多次 计数。
数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
*/
/*输入：nums = [1,3]
输出：6
解释：[1,3] 共有 4 个子集：
- 空子集的异或总和是 0 。
- [1] 的异或总和为 1 。
- [3] 的异或总和为 3 。
- [1,3] 的异或总和为 1 XOR 3 = 2 。
0 + 1 + 3 + 2 = 6
*/

/*输入：nums = [5,1,6]
输出：28
解释：[5,1,6] 共有 8 个子集：
- 空子集的异或总和是 0 。
- [5] 的异或总和为 5 。
- [1] 的异或总和为 1 。
- [6] 的异或总和为 6 。
- [5,1] 的异或总和为 5 XOR 1 = 4 。
- [5,6] 的异或总和为 5 XOR 6 = 3 。
- [1,6] 的异或总和为 1 XOR 6 = 7 。
- [5,1,6] 的异或总和为 5 XOR 1 XOR 6 = 2 。
0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
*/
/*[1,3]*/
public class Test206 {
    public static void main(String[] args) {
        int[] arr=new int[]{5,1,6};
        System.out.println(subsetXORSum(arr));
    }
    static int ans=0;
    public static int subsetXORSum(int[] nums) {
        //记录子集异或和
        //传入初始异或值为0，传入初始遍历下标为0
        dfs(nums,0,0);
        return ans;
    }
    //回溯法遍历所有位置元素Y与其后的所有数字求异或和
    public static void dfs(int[] nums,int xor,int index){
        //累加当前异或的结果
        //首先将当前异或值累加进来
        ans+=xor;
        //从index位置，向后遍历数组，直到数组的末尾
        for (int i = index; i <nums.length ; i++) {
            //将当前异或值与当前数组位置上的数字异或，将指针向后移动一位
            dfs(nums,xor^nums[i],i+1);
        }
    }
}

/*class Solution {

    int[] nums;
    int ans = 0;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        dfs(0,0);
        return ans;
    }

    void dfs(int xor,int index) {
        ans+=xor;
        for (int i = index; i < nums.length; i++) {
            dfs(xor^nums[i],i+1);
        }
    }

}*/
