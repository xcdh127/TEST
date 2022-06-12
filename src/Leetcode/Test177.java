package Leetcode;
/*给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
任何误差小于 10-5 的答案都将被视为正确答案。
*/
public class Test177 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(arr, 4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        //负最大表示最小值
        double res=-Double.MAX_VALUE;
        double sum=0.0;
        //滑动窗口
        int i=0;
        //扩大窗口
        for (int j = 0; j < nums.length; j++) {
            //敞口求和
            sum+=nums[j];
            //窗口长度为k
            if (j-i+1==k){
                //求平均
                res=Math.max(res,sum/k);
                //缩小窗口
                sum-=nums[i];
                i++;
            }
        }
        //返回结果
        return res;
    }
}
