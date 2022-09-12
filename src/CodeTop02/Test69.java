package CodeTop02;

/*给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
示例 1：
输入：x = 4
输出：2
示例 2：
输入：x = 8
输出：2
解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
提示：
0 <= x <= 231 - 1
*/
public class Test69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        //使用二分查找寻找符合条件的算术平方根
        int i = 1;
        int j = x;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (m > x / m) {
                j = m - 1;
            } else if (m * m <= x) {
                if ((m + 1) > x / (m + 1)) {
                    return m;
                }
                i = m + 1;
            }
        }
        return -1;
    }
}
