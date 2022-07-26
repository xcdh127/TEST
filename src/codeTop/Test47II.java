package codeTop;

import java.util.*;

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
public class Test47II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //存放结果
        List<List<Integer>> res=new ArrayList<>();
        //递归
        recur(res,nums,0);
        //返回结果
        return res;
    }

    public void recur(List<List<Integer>> res,int[] nums,int index){
        int n=nums.length;
        //当指针指到数组的末尾时，直接返回
        if (index==n){
            //创建一个链表，将数组元素放进链表中
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            //将链表放进结果中
            res.add(list);
            //返回
            return;
        }
        //从index开始向后遍历数组
        //set用来判断这个数字是否放进过集合当中，相同的数字交换位置会产生重复
        Set<Integer> set=new HashSet<>();
        for (int i = index; i < n; i++) {
            //当set中包含这个元素时，停止遍历数组
            if (set.contains(nums[i])){
                continue;
            }
            //将这个数字放进set集合中
            set.add(nums[i]);
            //交换数组的i位置和index位置
            swap(nums,i,index);
            //递归下一个位置
            recur(res,nums,index+1);
            //交换数组的i和index位置
            swap(nums,i,index);
        }
    }
    //交换数组的两个位置的数字
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
