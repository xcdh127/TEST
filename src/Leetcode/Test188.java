package Leetcode;
/*给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
*/
/*输入：arr = [1,2,4,4,4,4], m = 1, k = 3
输出：true
解释：模式 (4) 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
*/
public class Test188 {
    public boolean containsPattern(int[] arr, int m, int k) {
        //数组长度
        int n=arr.length;
        //以m为步长遍历数组
        for (int i = 0; i <= n-m*k; i++) {
            int offset;
            //遍历数组中全部偏移量开始的位置
            for (offset=0;offset<m*k;offset++){
                //因为模式省是将字符串进行重复
                if (arr[i+offset]!=arr[i+offset%m]){
                    break;
                }
            }
            //当偏移量等于m*k时，说明此时字符串的模式正确
            if (offset==m*k){
                return true;
            }
        }
        //此时模式不匹配，返回false
        return false;
    }
}

/*class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int l = 0; l <= n - m * k; ++l) {
            int offset;
            for (offset = 0; offset < m * k; ++offset) {
                if (arr[l + offset] != arr[l + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;
    }
}
=*/
