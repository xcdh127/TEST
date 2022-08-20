package CodeDream;

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
        //当指针指到数组的末尾时
        if (index == nums.length) {
            //新建一个list
            List<Integer> list = new ArrayList<>();
            //将数组中的元素都添加到list中
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            //结果集中添加list
            res.add(list);
            return;
        }
        //判断数字之前有没有遍历过
        Set<Integer> set = new HashSet<>();
        //从index开始向后遍历数组
        for (int i = index; i < nums.length; i++) {
            //如果之前放过这个数字，跳过
            if (set.contains(nums[i])) {
                continue;
            }
            //将数字放进set中
            set.add(nums[i]);
            //交换i与index的位置
            swap(nums, i, index);
            //遍历下一个位置
            recur(res, nums, index + 1);
            //交换回来
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
