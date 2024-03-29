package CodeTop02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
*/
public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] nums, int index) {
        int n = nums.length;
        if (index == n) {
            res.add(new LinkedList<>(subset));
            return;
        }
        //不将当前节点放进子集
        recur(res, subset, nums, index + 1);
        //将当前节点放进子集
        subset.addLast(nums[index]);
        recur(res, subset, nums, index + 1);
        //删除最后放进去的节点
        subset.removeLast();
    }
}
