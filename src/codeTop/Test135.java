package codeTop;

/*n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
你需要按照以下要求，给这些孩子分发糖果：
每个孩子至少分配到 1 个糖果。
相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
示例1：
输入：ratings = [1,0,2]
输出：5
解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
示例2：
输入：ratings = [1,2,2]
输出：4
解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
提示：
n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
*/
public class Test135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        //先从左到右遍历数组，找右边比左边高的同学，多加一个糖果
        //右边的朋友比左边的人的评分高时，比左边的人的糖果多1个
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        //再从右向左遍历数组，找左边比右边高的同学，多加一个糖果
        //左边的人的评分比右边的人高，比右边的人多一个糖果,取右边人的糖果数量和当前位置的糖果数量的较大值
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i + 1] + 1, count[i]);
            }
        }
        //res结果为0
        int res = 0;
        for (int num : count) {
            //累加数组中的数字
            res += num;
        }
        //加上基础的糖果数量
        return res + n;
    }
}

class Solution20 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        for (int i = 1; i < n; i++) {
            //右边的人比左边的人的评分高时，比左边的人的糖果多1个
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        //左边的人评分比右边的人高，比右边的人多一个糖果
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i + 1] + 1, count[i]);
            }
        }
        int res = 0;
        for (int num : count) {
            res += num;
        }
        return res + n;
    }
}
