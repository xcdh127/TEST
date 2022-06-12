package Leetcode;
/*给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
如果不存在这个只出现一次的整数，则返回 -1。*/
public class Test58 {
    public int largestUniqueNumber(int[] nums) {
        int n=nums.length;
        //用于存放当前数组中出现的数字次数
        int[] arr=new int[1001];
        for (int i = 0; i <n; i++) {
            arr[nums[i]]++;
        }
        //从后向前遍历数组，第一个值为1的数字就是最大的唯一数字
        for (int i = 1000; i >=0 ; i--) {
            if (arr[i]==1){
                return i;
            }
        }
        //没有找到返回-1
        return -1;
    }
}
