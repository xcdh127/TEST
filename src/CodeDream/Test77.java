package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。
示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：
输入：n = 1, k = 1
输出：[[1]]
提示：
1 <= n <= 20
1 <= k <= n
*/
public class Test77 {
    public List<List<Integer>> combine(int n, int k) {
        //新建结果集合
        List<List<Integer>> res = new ArrayList<>();
        //子集subset
        LinkedList<Integer> subset = new LinkedList<>();
        //从1开始向后遍历
        recur(res, subset, 1, n, k);
        //返回结果
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int index, int n, int k) {
        //index指向n+1时结束
        if (index == n + 1) {
            return;
        }

        //不将当前数字放进子集中
        recur(res, subset, index + 1, n, k);

        //将当前数字放进子集中
        subset.addLast(index);
        //当子集的大小等于k时
        if (subset.size() == k) {
            //向结果中添加子集
            res.add(new LinkedList<>(subset));
        }
        recur(res, subset, index + 1, n, k);
        //回到父节点时的状态，将最后放进子集的数字删除
        subset.removeLast();
    }
}
