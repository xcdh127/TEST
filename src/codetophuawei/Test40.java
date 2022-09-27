package codetophuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。
注意：解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]
提示:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/
public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, candidates, 0, target, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] candidates, int sum, int target, int index) {
        int n = candidates.length;
        //当子集和等于目标值时，将子集添加到结果集中
        if (sum == target) {
            res.add(new LinkedList<>(subset));
            return;
        }
        //当遍历到数组的末尾时，返回
        if (index == n) {
            return;
        }

        //当指针没有指向数组的末尾时，并且和小于目标值时
        if (index < n && sum < target) {
            //不将当前数字放进到子集中
            recur(res, subset, candidates, sum, target, getNext(candidates, index));
            //将当前数字放进到子集中
            sum += candidates[index];
            subset.addLast(candidates[index]);
            recur(res, subset, candidates, sum, target, index + 1);
            //将最后放进子集的元素删除
            subset.removeLast();
        }
    }

    //拿到不同于当前数字的下一个数字的下标
    public int getNext(int[] candidates, int index) {
        int n = candidates.length;
        int next = index;
        while (next < n && candidates[index] == candidates[next]) {
            next++;
        }
        return next;
    }
}













