package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*「无零整数」是十进制表示中 不含任何 0 的正整数。
给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
A 和 B 都是无零整数
A + B = n
题目数据保证至少有一个有效的解决方案。
如果存在多个有效解决方案，你可以返回其中任意一个。
*/
/*输入：n = 2
输出：[1,1]
解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。*/
public class Test275 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i+j==n && !isContainsZero(i) && !isContainsZero(j)){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    public boolean isContainsZero(int num){
        if (num==0)return true;
        while (num>0){
            int yuShu=num%10;
            if (yuShu==0)return true;
            num/=10;
        }
        return false;
    }
}
