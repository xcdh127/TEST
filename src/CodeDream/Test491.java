package CodeDream;

import java.util.*;

/*给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，
递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
示例 1：
输入：nums = [4,6,7,7]
输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
示例 2：
输入：nums = [4,4,3,2,1]
输出：[[4,4]]
提示：
1 <= nums.length <= 15
-100 <= nums[i] <= 100
*/
public class Test491 {
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, nums, 0);
        return res;
    }

    public static void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] nums, int index) {
        //子集的大小大于等于2时
        if (subset.size() >= 2) {
            //结果集中添加子集
            res.add(new LinkedList<>(subset));
        }
        //去除重复的元素
        Set<Integer> set = new HashSet<>();
        //遍历从index开始向后的数组
        for (int i = index; i < nums.length; i++) {
            //如果之前遍历过这个数字 或者子集非空并且子集最后放进去的元素大于当前元素，跳过
            if (set.contains(nums[i]) || !subset.isEmpty() && subset.getLast() > nums[i]) {
                continue;
            }
            //当前数字遍历过
            set.add(nums[i]);
            //子集中添加当前数字
            subset.addLast(nums[i]);
            //遍历数组的下一个位置
            recur(res, subset, nums, i + 1);
            //删除放入子集的最后一个元素
            subset.removeLast();
        }
    }
}
