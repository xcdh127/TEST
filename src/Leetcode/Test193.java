package Leetcode;
/*给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。*/
public class Test193 {
    public int findMaxConsecutiveOnes(int[] nums) {
        //统计连续1的最大长度
        int count=0;
        //指向数组的指针
        int index=0;
        //数组长度
        int n=nums.length;
        while (index<n){
            //开始下标
            int start=index;
            //当前数字
            int num=nums[index];
            //数字1才统计最长连续长度
            if (num==1){
                //直到为0，或者到达数组的末尾
                while (index<n && num==nums[index]){
                    index++;
                }
                //记录最大连续1的长度
                count=Math.max(count,index-start);
            }
            //否则遍历下一位
            else {
                index++;
            }
        }
        //返回结果
        return count;
    }
}
