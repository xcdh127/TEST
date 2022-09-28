package codetophuawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
public class Test47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res, nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, int[] nums, int index) {
        int n = nums.length;
        if (index == n) {
            //遍历到数组的末尾，形成排列，将数组放进list中
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            //向结果集中添加list
            res.add(list);
            return;
        }
        //数组中有重复数字，记录下已经有的数字，避免重复
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < n; i++) {
            //集合中存在当前数字，直接跳过
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, i, index);
            recur(res, nums, index + 1);
            swap(nums, i, index);
        }
    }

    //交换数组中的两个数字
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
