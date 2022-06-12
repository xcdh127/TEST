package Leetcode;
/*给你一个由若干 0 和 1 组成的字符串 s ，
请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串
和 右 子字符串）所能获得的最大得分。
「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 */
public class Test121 {
    public int maxScore(String s) {
        int n=s.length();
        int maxSorce=0;
        for (int i = 1; i < n; i++) {
            //左边字符串中0的个数
            int left=0;
            //左边只能从第一个字符后切分
            for (int k=0;k<i;k++){
                if (s.charAt(k)=='0'){
                    left++;
                }
            }
            //右边字符串中1的个数
            int right=0;
            //右边只能从最后一个字符前切分
            for (int j = i; j < n; j++) {
                if (s.charAt(j)=='1'){
                    right++;
                }
            }
            //返回最大的得分
            maxSorce=Math.max(maxSorce,left+right);
        }
        return maxSorce;
    }
}
