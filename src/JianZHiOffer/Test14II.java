package JianZHiOffer;
/*给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，
当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
*/
public class Test14II {
    public int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }
        //先求出余数
        int r=n%3;
        //计算n中有几个3
        int m=n/3-1;
        int MOD=1000000007;
        long x=3;
        //记录结果
        long res=1;
        while (m>0){
            //如果m是奇数，结果再乘上3
            if ((m&1)==1){
                res=(res*x)%MOD;
            }
            //对当前的x求平方，取余数
            x=(x*x)%MOD;
            //将m个数减半
            m>>=1;
        }
        //最后通过余数获取最后的乘积结果
        //余数为0，此时那个3乘上去
        if (r==0){
            return (int)((res*3)%MOD);
        }
        //余数为1，此时那个3拆成2*2，乘积更大
        else if (r==1){
            return (int)((res*4)%MOD);
        }
        //余数为2，此时乘2再乘3
        else {
            return (int)((res*6)%MOD);
        }
    }
}

/*class Solution {
    public int cuttingRope(int n) {
    if(n<=3) return n-1;
    int m=n/3-1;
    int r=n%3;
    long x=3;
    long res =1;
    while(m>0){
    if((m&1)==1) res=(res*x)%1000000007;
    x=(x*x)%1000000007;
    m>>=1;
    }
    if(r==0) return (int)((res*3)%1000000007);
    else if(r==1) return (int)((res*4)%1000000007);
    return (int)((res*6)%1000000007);
    }
}*/