package Jianzhioffer02;

/*请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
public class Test48 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        //窗口左边界
        int i = 0;
        //最大长度
        int maxLen = Integer.MIN_VALUE;
        //统计字符出现次数的数组
        int[] arr = new int[256];
        //记录重复字母的个数
        int mutil = 0;
        //遍历字符串
        for (int j = 0; j < n; j++) {
            //入窗口
            arr[s.charAt(j)]++;
            //当前字母个数等于2时，重复字母的个数+1
            if (arr[s.charAt(j)] == 2) {
                mutil++;
            }
            //当重复字母个数大于0时
            while (mutil > 0) {
                //缩小窗口
                arr[s.charAt(i)]--;
                //当左窗口的个数等于1时，重复数字的个数-1
                if (arr[s.charAt(i)] == 1) {
                    mutil--;
                }
                //继续缩小窗口
                i++;
            }
            //记录滑动窗口的最大长度
            maxLen = Math.max(maxLen, j - i + 1);
        }
        //返回最大长度
        return maxLen;
    }
}
