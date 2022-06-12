package Leetcode;
/*给你一个长度为 n 的整数数组 nums ，
请你返回 nums 中最 接近 0 的数字。如果有多个答案，
请你返回它们中的 最大值 。
*/
public class Test255 {
    public int findClosestNumber(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int num :nums) {
            if (Math.abs(num)<min){
                max=num;
                min=Math.abs(num);
            }
            else if (Math.abs(num)==min){
                if (max<num){
                    max=num;
                }
            }
        }
        return max;
    }
}
