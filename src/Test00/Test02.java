package Test00;
/*479. 最大回文数乘积
给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。
因为答案可能非常大，所以返回它对 1337 取余 。



示例 1:

输入：n = 2
输出：987
解释：99 x 91 = 9009, 9009 % 1337 = 987
示例 2:

输入： n = 1
输出： 9


提示:

1 <= n <= 8*/
public class Test02 {
}
class Solution2 {
    public int largestPalindrome(int n) {
        if(n==1){
            return 9;
        }
        int ans=0;
        int upper=(int)Math.pow(10,n)-1;
        for(int i=upper;ans==0;i--){
            long p=i;
            for(int x=i;x>0;x/=10){
                p=p*10+x%10;
            }
            for(long x=upper;x*x>=p;x--){
                if(p%x==0){
                    ans=(int)(p%1337);
                    break;
                }
            }
        }
        return ans;
    }
}
