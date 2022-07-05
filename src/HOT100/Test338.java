package HOT100;
/*给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
示例 1：
输入：n = 2
输出：[0,1,1]
解释：
0 --> 0
1 --> 1
2 --> 10
示例 2：
输入：n = 5
输出：[0,1,1,2,1,2]
解释：
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
提示：
0 <= n <= 105
进阶：
很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
*/
public class Test338 {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        for (int i = 0; i <= n; i++) {
            int num=i;
            int count=0;
            while (num>0){
                count++;
                num=num&(num-1);
            }
            res[i]=count;
        }
        return res;
    }
}
