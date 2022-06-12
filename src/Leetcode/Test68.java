package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
*/
public class Test68 {
/*    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for (int num :nums) {
            if (set.contains(num)){
                list.add(num);
            }
            else set.add(num);
        }
        return list;
    }*/
/*[4,3,2,7,8,2,3,1]*/
public static void main(String[] args) {
    int[] arr=new int[]{4,3,2,7,8,2,3,1};
    findDuplicates(arr);

}
    public static List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        //记录出现两次的数字
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //当前i位置上的数字不等于(当前位置上的数字-1)位置上的数字时，交换数组中这两个位置上的数字
            while (nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        //遍历数组，当前位置上的数字不等于下标+1时，就将该位置上的数字添加到出现两次的数组中
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i+1){
                list.add(nums[i]);
            }
        }
        //返回结果
        return list;
    }
    //交换数组中，两个位置上的数字
    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
