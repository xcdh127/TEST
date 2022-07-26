package codeTop;
/*实现pow(x, n)，即计算 x 的整数n 次幂函数（即，xn ）。
示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：
输入：x = 2.10000, n = 3
输出：9.26100
示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
提示：
-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
*/
public class Test50 {
    public double myPow(double x, int n) {
        //结果res
        double res=1.0;
        //当x为0时，直接返回0
        if (x==0){
            return 0.0;
        }
        //将n转成长整形数字
        long b=n;
        //如果b是负数，就将x置为倒数1/x
        if (n<0){
            x=1/x;
            b=-b;
        }
        while (b>0){
            //当b是奇数时，将结果res*x;
            if (b%2==1){
                res=res*x;
            }
            //快速幂法，x自乘
            x*=x;
            //将b右移动1位，数字b减半
            b>>=1;
        }
        //返回最后的结果
        return res;
    }
}
class Solution11 {
    public double myPow(double x, int n) {
        if(x==0){
            return 0.0;
        }
        long b=n;
        if(b<0){
            b=-b;
            x=1/x;
        }
        double res=1.0;
        while(b>0){
            if(b%2==1){
                res=res*x;
            }
            x*=x;
            b>>=1;
        }
        return res;
    }
}