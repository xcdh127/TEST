package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的每个数字在每个组合中只能使用一次。
注意：解集不能包含重复的组合。
示例1:
输入: candidates =[10,1,2,7,6,1,5], target =8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例2:
输入: candidates =[2,5,2,1,2], target =5,
输出:
[
[1,2,2],
[5]
]
提示:
1 <=candidates.length <= 100
1 <=candidates[i] <= 50
1 <= target <= 30
*/
public class Test40 {
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        int n = candidates.length;
        //排序数组，跳过不想选择的数字
        Arrays.sort(candidates);
        recur(res, subset, candidates, target, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] candidates, int target, int index) {
        int n = candidates.length;
        //当子数组的和等于target时，将当前子集添加到结果集中
        if (sum == target) {
            res.add(new LinkedList<Integer>(subset));
            return;
        }
        //和大于目标值，或者指针到达数组的末尾
        if (sum>target || index == n) {
            return;
        }
        //不将当前数字放进数组中
        recur(res, subset, candidates, target, getNext(candidates, index));
        //将当前数字放进数组中
        subset.addLast(candidates[index]);
        //刚刚的数字累加到累加和中
        sum += candidates[index];
        recur(res, subset, candidates, target, index + 1);
        //将和减去当前位置的值
        subset.removeLast();
        //累加和删除掉刚刚添加进来的结果
        sum-=candidates[index];
    }

    //获取数组中，下一个不同的数字
    public int getNext(int[] nums, int index) {
        int n = nums.length;
        int next = index;
        while (next < n && nums[index] == nums[next]) {
            next++;
        }
        return next;
    }
}
