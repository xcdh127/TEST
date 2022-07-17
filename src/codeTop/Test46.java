package codeTop;

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
public class Test46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        recur(res,nums,0);
        return res;
    }

    public void recur(List<List<Integer>> res,int[] nums,int index){
        int n=nums.length;
        if (index==n){
            //list放数组中的元素
            List<Integer> list=new ArrayList<>();
            //像链表中添加
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            //向结果中添加数组
            res.add(new ArrayList<>(list));
            return;
        }
        //如果没有遍历到数组的末尾，从index开始遍历到数组的末尾
        for (int i = index; i < n; i++) {
            //交换index与i位置的数字
            swap(nums,i,index);
            //进行下一个位置的递归
            recur(res,nums,index+1);
            //再把两个数字交换回来
            swap(nums,i,index);
        }
    }

    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
