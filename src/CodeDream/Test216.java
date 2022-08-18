package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
只使用数字1到9
每个数字 最多使用一次 
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
解释:
1 + 2 + 4 = 7
没有其他符合的组合了。
示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
解释:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
没有其他符合的组合了。
示例 3:
输入: k = 4, n = 1
输出: []
解释: 不存在有效的组合。
在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
提示:
2 <= k <= 9
1 <= n <= 60
*/
public class Test216 {
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        recur(res, subset, 1, n, k);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int index, int n, int k) {
        if (index == 10) {
            return;
        }
        //不将数字放进子集中
        recur(res, subset, index + 1, n, k);

        //将数字放进子集
        sum += index;
        subset.addLast(index);
        //和为n并且子集大小为k，添加到结果集中
        if (sum == n && subset.size() == k) {
            res.add(new LinkedList<>(subset));
        }
        recur(res, subset, index + 1, n, k);
        //删除掉最后添加到子集的数字
        sum -= index;
        subset.removeLast();
    }
}
