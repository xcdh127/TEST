package codetophuawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
对于给定的输入，保证和为 target 的不同组合数少于 150 个。
示例 1：
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
示例 2：
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
示例 3：
输入: candidates = [2], target = 1
输出: []
*/
public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, candidates, 0, target, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] candidates, int sum, int target, int index) {
        int n = candidates.length;
        //当子集和等于target时，将集合放进结果集中
        if (sum == target) {
            res.add(new LinkedList<>(subset));
            return;
        }
        //当指针直到数组的末尾时，返回
        if (index == n) {
            return;
        }
        if (sum < target && index < n) {
            //不将数字放进子集
            recur(res, subset, candidates, sum, target, index + 1);

            //将数字放进子集中
            sum += candidates[index];
            subset.addLast(candidates[index]);
            recur(res, subset, candidates, sum, target, index);
            //移除最后放进来的数字
            subset.removeLast();
        }
    }
}
