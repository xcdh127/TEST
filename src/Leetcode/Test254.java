package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*Given an integer array nums, return true if nums is consecutive, otherwise return false.
An array is consecutive if it contains every number in the range
 [x, x + n - 1] (inclusive), where x is the minimum number
 in the array and n is the length of the array.
*/
public class Test254 {
    public boolean isConsecutive(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            min=Math.min(min,nums[i]);
        }
        for (int num:nums) {
            if (set.contains(num) || num<min || num>min+n-1){
                return false;
            }
            else {
                set.add(num);
            }
        }
        return true;
    }
}
