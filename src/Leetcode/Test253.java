package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，
那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。
数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
*/
/*输入：nums = [1,2,10,5,7]
输出：true
解释：从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
[1,2,5,7] 是严格递增的，所以返回 true 。
*/
public class Test253 {
    public boolean canBeIncreasing(int[] nums) {
        int count=0;
        for (int i = 1; i < nums.length && count<=1; i++) {
            if (nums[i]>nums[i-1])continue;
            //当后面的数字小于等于后面的数字时，计数+1
            count++;
            if (i-1>0 && nums[i]<=nums[i-2]){
                nums[i]=nums[i-1];
            }
        }
        return count<=1;
    }

}
/*class Solution {
  public boolean canBeIncreasing(int[] nums) {
    int cnt = 0;
    for (int i = 1; i < nums.length && cnt <= 1; i++) {
      if (nums[i] > nums[i - 1]) continue;
      cnt++;
      if (i - 1 > 0 && nums[i] <= nums[i - 2]) {
        nums[i] = nums[i - 1];
      } //else {
        //nums[i - 1] = nums[i];
      //}
    }
    return cnt <= 1;
  }
}
*/