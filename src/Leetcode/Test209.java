package Leetcode;
/*给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。*/
/*输入：nums = [12,345,2,6,7896]
输出：2
解释：
12 是 2 位数字（位数为偶数） 
345 是 3 位数字（位数为奇数）  
2 是 1 位数字（位数为奇数） 
6 是 1 位数字 位数为奇数） 
7896 是 4 位数字（位数为偶数）  
因此只有 12 和 7896 是位数为偶数的数字
*/
public class Test209 {
    public int findNumbers(int[] nums) {
        int count=0;
        for (int num :nums) {
            //数字位数为偶数时，计数+1
            if (countBit(num)%2==0){
                count++;
            }
        }
        //返回结果
        return count;
    }
    //记录数字位数
    public int countBit(int num){
        int count=0;
        while (num>0){
            num/=10;
            count++;
        }
        return count;
    }
}
