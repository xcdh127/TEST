package Leetcode;
/*请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；
你需要返回可能的方案总数。
让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
*/
public class Test273 {
    int mod = (int) (1e9 + 7);
    public int numPrimeArrangements(int n) {
        int countZhiShu=0;
        for (int i = 1; i <=n ; i++) {
            if (isZhiShu(i)){
                countZhiShu++;
            }
        }
        long res=jieCheng(countZhiShu);
        res*=jieCheng(n-countZhiShu);
        return (int)(res%mod);
    }

    public long jieCheng(int n){
        long res=1;
        for (int i = 1; i <=n ; i++) {
            res*=(long)i;
            res%=mod;
        }
        return res;
    }

    public boolean isZhiShu(int num){
        if (num==1)return false;
        if (num==2)return true;
        for (int i = 2; i <=Math.sqrt(num) ; i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}


/*class Solution {
	int mod = (int) 1e9 + 7;

	public int numPrimeArrangements(int n) {
		int prime = 0;
		for (int i = 1; i <= n; i++) {
			if (isPrime(i)) {
				prime++;
			}
		}
		long ans = factorial(prime);
		ans *= factorial(n - prime);
		return (int) (ans % mod);
	}

	private long factorial(int num) {
		long ans = 1;
		for (int i = 1; i <= num; i++) {
			ans *= (long) i;
			ans %= mod;
		}
		return ans;
	}

	private boolean isPrime(int num) {
		if (num == 2) {
			return true;
		}
		if (num == 1 || num % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0 || i * i == num) {
				return false;
			}
		}
		return true;
	}
}
*/
