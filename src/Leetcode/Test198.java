package Leetcode;
/*给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，
数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
ans[i] == nums[i]
ans[i + n] == nums[i]
具体而言，ans 由两个 nums 数组 串联 形成。
返回数组 ans 。
*/
public class Test198 {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        //创建长度是原数组两倍的数组
        int[] arr=new int[2*n];
        //将i位置对应的数组与i+n位置对应的数字填充到arr数组中
        for (int i = 0; i < n; i++) {
            arr[i]=nums[i];
            arr[i+n]=nums[i];
        }
        //返回结果
        return arr;
    }
}
