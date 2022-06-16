package JianZHiOffer;

import java.util.Arrays;

/*从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
示例 1:
输入: [1,2,3,4,5]
输出: True
示例 2:
输入: [0,0,1,2,5]
输出: True
限制：
数组长度为 5 
数组的数取值为 [0, 13] .
*/
public class Test67 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count_0=0;
        int count_dif=0;
        for (int i = 0; i <n ; i++) {
            if (nums[i]==0){
                count_0++;
            }
            if (nums[i]!=0 && i<n-1 && nums[i]==nums[i+1]){
                return false;
            }
            if (nums[i]!=0 && i<n-1 && nums[i]!=nums[i+1]){
                count_dif+=nums[i+1]-nums[i]-1;
            }
        }
        return count_0>=count_dif;
    }
}
