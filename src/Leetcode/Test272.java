package Leetcode;
/*给你一个整数 n ，让你来判定他是否是 阿姆斯特朗数，是则返回 true，不是则返回 false。
假设存在一个 k 位数 n ，其每一位上的数字的 k 次幂的总和也是 n ，那么这个数是阿姆斯特朗数 。
*/
public class Test272 {
    public boolean isArmstrong(int n) {
        String num=String.valueOf(n);
        int k=num.length();
        long sum=0;
        long nL=n;
        while (nL>0){
            long yushu=nL%10;
            sum+=Math.pow(yushu,k);
            nL/=10;
        }
        return sum==n;
    }
}
