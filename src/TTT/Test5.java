package TTT;

public class Test5 {
    public static void main(String[] args) {

    }
/*给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。

丑数是可以被 a 或 b 或 c 整除的 正整数 。

 */
    public static int nthUglyNumber(int n, int a, int b, int c) {
        long ans=0;
        long l=0;
        long r=(long)Math.min(a,Math.min(b,c))*n;
        //ab的最小公约数
        long ab=lcm(a,b);
        long ac=lcm(a,c);
        long bc=lcm(b,c);
        //求abc的最小公倍数
        long abc=lcm(b,ac);
        while(l<=r){
            long m=l+((r-1)>>1);
            long N=m/a+m/b+m/c-m/ab-m/ac-m/bc+m/abc;
            if(N<n){
                l=m+1;
                ans=l;
            }
            else{
                r=m-1;
            }
        }
        return (int)ans;
    }
    //求两个数字的最大公约数
    public static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
    //求两个数字的最小公倍数
    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
}
