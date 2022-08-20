package CodeDream;

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
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, candidates, target, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] candidates, int target, int index) {
        //当和等于目标值时，将子集放进结果中
        if (sum == target) {
            res.add(new LinkedList<>(subset));
        }
        if (index == candidates.length) {
            return;
        }
        if (sum < target) {
            //当前数字不放进子集中
            recur(res, subset, candidates, target, getNext(candidates, index));
            //将当前数字放进子集中
            sum += candidates[index];
            subset.addLast(candidates[index]);
            //处理下一个位置
            recur(res, subset, candidates, target, index + 1);
            //删除刚刚方进去的数字
            sum -= candidates[index];
            subset.removeLast();
        }
    }

    //获取下一个不相同的数字
    public int getNext(int[] arr, int index) {
        int next = index;
        while (next < arr.length && arr[next] == arr[index]) {
            next++;
        }
        return next;
    }
}
