
package Leetcode;
/*桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，
拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
示例 1：
输入：[4,2,1]
输出：4
解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，
第三堆最少需要拿 1 次，总共 4 次即可拿完。
示例 2：
输入：[2,3,10]
输出：8
限制：
1 <= n <= 4
1 <= coins[i] <= 10
*/
public class Test212 {
    public int minCount(int[] coins) {
        //记录拿币次数
        int count=0;
        //贪心，每次拿两枚
        for (int num :coins) {
            count+=num%2==0?num/2:num/2+1;
        }
        return count;
    }
}
