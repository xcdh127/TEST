package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：
输入：nums = [1]
输出：[[1]]
提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
*/
public class Test46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res, nums, 0);
        return res;
    }

    public void recur(List<List<Integer>> res, int[] nums, int index) {
        //当指针指到数组的末尾时
        if (index == nums.length) {
            //将数组中的元素放进list中
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            //将此数组排列放进结果集中
            res.add(new ArrayList<>(list));
            return;
        }
        //从index开始，交换数组中的两个元素构造新的全排列
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            //遍历下一个位置index+1
            recur(res, nums, index + 1);
            swap(nums, i, index);
        }
    }

    //交换数组中两个位置的数字
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
