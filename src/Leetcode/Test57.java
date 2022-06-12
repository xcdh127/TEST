package Leetcode;

import java.util.Arrays;

/*两个数对 (a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。
例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，
使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。
返回以这种方式取得的乘积差中的 最大值 。
*/
public class Test57 {
    public int maxProductDifference(int[] nums) {
        //将数组进行排序
        Arrays.sort(nums);
        int n=nums.length;
        //由于数组中全都是正数，所以最大乘积为最大的两个数字乘积-最小的两个数字乘积
        return (nums[n-1]*nums[n-2]-nums[0]*nums[1]);
    }
}
