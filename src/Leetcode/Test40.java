package Leetcode;

import java.util.Arrays;

/*给定由一些正数（代表长度）组成的数组 nums ，返回
由其中三个长度组成的、面积不为零的三角形的最大周长 。
如果不能形成任何面积不为零的三角形，返回 0。*/
public class Test40 {
    public int largestPerimeter(int[] nums) {
        //对数组排序
        Arrays.sort(nums);
        //数组长度
        int n=nums.length;
        //贪心思想：周长最长那么就找相邻的最大的边长
        for (int i = n-1; i >=2 ; i--) {
            //两个短边相加大于长边，那么就构成面积不为0的三角形
            if (nums[i-1]+nums[i-2]>nums[i]){
                return nums[i-1]+nums[i-2]+nums[i];
            }
        }
        return 0;
    }
}
