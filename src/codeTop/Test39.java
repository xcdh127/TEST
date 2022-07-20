package codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
对于给定的输入，保证和为target 的不同组合数少于 150 个。
示例1：
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
示例2：
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
示例 3：
输入: candidates = [2], target = 1
输出: []
提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都 互不相同
1 <= target <= 500
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
        //当index到达数组的末尾时，直接返回
        if (index == n) {
            return;
        }
        //当和等于target时，将子集添加到结果中
        if (sum == target) {
            res.add(new LinkedList<>(subset));
        }
        //当和小于target时，并且index<n时
        else if (sum<target && index<n){
            //不将当前数字添加到子集中
            recur(res, subset, candidates, sum, target, index + 1);
            //sum加上index处的值
            sum+=candidates[index];
            //将当前数字添加到子集末尾
            subset.addLast(candidates[index]);
            //因为可以重复将数字添加到子集中
            recur(res, subset, candidates, sum, target, index);
            //子集删除刚刚添加进来的元素
            subset.removeLast();
        }
    }
}
