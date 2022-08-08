package codeTop;
/*给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。
示例 1：
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
提示：
1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105
*/
public class Test55 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        //能够到达的最远位置
        int maxPos=0;
        for (int i=0;i<=maxPos;i++){
            //最远能到达的距离为maxPos，取i位置+nums[i],与maxPos的较大者
            maxPos=Math.max(i+nums[i],maxPos);
            //当最远能够到达的就离大于等于n-1时，返回true
            if (maxPos>=n-1){
                return true;
            }
        }
        //能够跳到的最远距离，到不了数组的末尾位置
        //返回false
        return false;
    }
}
class Solution18 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        //最远能够跳到的地方
        int maxPos=0;
        //当前没有跳到最远能够跳到的地方时就继续向后跳
        for (int i = 0; i <=maxPos ; i++) {
            //更新最远能够跳到的地方
            if (i+nums[i]>maxPos){
                maxPos=i+nums[i];
            }
            //当前可以跳到的最远距离到达了数组的最后位置
            if (maxPos>=n-1){
                return true;
            }
        }
        //最远距离到不了数组的最后位置
        return false;
    }
}