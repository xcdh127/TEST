package codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：
输入：nums = [0]
输出：[[],[0]]
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
*/
public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {
        //结果集
        List<List<Integer>> res=new ArrayList<>();
        //子集
        LinkedList<Integer> subset=new LinkedList<>();
        //迭代
        recur(res,subset,nums,0);
        //返回结果
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset, int[] nums, int index){
        int n=nums.length;
        //当遍历到数组的末尾时，此时构成一个子集
        if (index==n){
            res.add(new LinkedList<>(subset));
            return;
        }
        //不将当前数组中的元素添加到子集中
        recur(res,subset,nums,index+1);
        //将当前数组中的元素添加到子集中
        subset.addLast(nums[index]);
        //继续后续的递归
        recur(res,subset,nums,index+1);
        //删除刚刚添加进来的数字
        subset.removeLast();
    }
}
