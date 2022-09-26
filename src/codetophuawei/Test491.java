package codetophuawei;

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
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] nums, int index) {
        int n = nums.length;
        if (subset.size() >= 2) {
            res.add(new LinkedList<>(subset));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i]) || !subset.isEmpty() && subset.getLast() > nums[i]) {
                continue;
            }
            //i位置的数字以及存在
            set.add(nums[i]);
            //向子集中添加当前数字
            subset.addLast(nums[i]);
            //从i+1位置向后回溯
            recur(res, subset, nums, i + 1);
            //删除掉最后添加到数组中的元素
            subset.removeLast();
        }
    }
}

class Solution90 {

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, nums, 0);
        return res;
    }

    public static void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] nums, int index) {
        if (subset.size() >= 2) {
            res.add(new LinkedList<>(subset));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i]) || !subset.isEmpty() && subset.getLast() > nums[i]) {
                continue;
            }
            set.add(nums[i]);
            subset.addLast(nums[i]);
            recur(res, subset, nums, i + 1);
            subset.removeLast();
        }
    }
}
