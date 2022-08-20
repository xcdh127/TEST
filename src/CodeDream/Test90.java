package CodeDream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
示例 1：
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
public class Test90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        //对数组排序，便于找到数字中不同的下一个数字的位置
        Arrays.sort(nums);
        recur(res, subset, nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int nums[], int index) {
        //指针直到数组末尾时，将子集添加到子集中
        if (index == nums.length) {
            res.add(new LinkedList<>(subset));
            return;
        }
        //不将这个数字放进子集中
        recur(res, subset, nums, getNext(nums, index));
        //将当前数字放进子集
        subset.addLast(nums[index]);
        //遍历下一个位置
        recur(res, subset, nums, index + 1);
        //删除最后放进子集的元素
        subset.removeLast();
    }

    //获取下一个不同数字的位置
    public int getNext(int[] nums, int index) {
        int next = index;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        return next;
    }

}
