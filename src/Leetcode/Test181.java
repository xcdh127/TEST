package Leetcode;
/*有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。
自行车手从海拔为 0 的点 0 开始骑行。
给你一个长度为 n 的整数数组 gain ，
其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
*/
/*输入：gain = [-5,1,5,0,-7]
输出：1
解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。*/
public class Test181 {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        //记录前缀和
        int[] pre=new int[n+1];
        pre[0]=0;
        for (int i = 1; i <=n ; i++) {
            pre[i]=pre[i-1]+gain[i-1];
        }
        //记录前缀和数组中的最大值
        int maxValue=Integer.MIN_VALUE;
        for (int num :pre) {
            maxValue=Math.max(maxValue,num);
        }
        //返回最大值
        return maxValue;
    }
}
