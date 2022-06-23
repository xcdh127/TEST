package HOT100;

import java.util.ArrayList;
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
public class Test21 {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        recur(res,nums,0);
        return res;
    }

    public void recur(List<List<Integer>> res,int[] nums,int index){
        int n=nums.length;
        if (index==n){
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }
        for (int i = index; i <n ; i++) {
            swap(nums,i,index);
            //逐个交换位置，直到数组的最后位置
            recur(res,nums,index+1);
            //恢复数组到父节点时的状态
            swap(nums,i,index);
        }
    }

    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
