package Leetcode;
/*给你一个正整数的数组 A。
然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。
*/
public class Test229 {
    public int sumOfDigits(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num<min){
                min=num;
            }
        }
        int sum=caclulateBit(min);
        if (sum%2==0){
            return 1;
        }
        else return 0;

    }
    public int caclulateBit(int num){
        int count=0;
        while (num>0){
            int yuShu=num%10;
            count+=yuShu;
            num/=10;
        }
        return count;
    }
}
