package codeTop;
/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
提示：
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/
public class Test42 {
    public int trap(int[] height) {
        int n=height.length;
        int[] left=new int[n];
        int[] right=new int[n];
        //记录从左向右最大值
        int maxLeft=0;
        //记录从右向左最大值
        int maxRight=0;
        //记录结果
        int res=0;
        //从左到右取最大值
        for (int i = 0; i < n; i++) {
            maxLeft=Math.max(maxLeft,height[i]);
            left[i]=maxLeft;
        }
        //从右向左取最大值
        for (int i = n-1; i >=0 ; i--) {
            maxRight=Math.max(maxRight,height[i]);
            right[i]=maxRight;
        }
        //遍历数组，取两个数组较小值-当前高度，累加起来
        for (int i = 0; i < n; i++) {
            res+=Math.min(left[i],right[i])-height[i];
        }
        //返回结果
        return res;
    }
}
