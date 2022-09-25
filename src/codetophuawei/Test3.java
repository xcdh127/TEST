package codetophuawei;

/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
*/
public class Test3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int mutil = 0;
        int i = 0;
        int maxLen = 0;
        //存放字符以及出现次数
        int[] arr = new int[256];
        for (int j = 0; j < n; j++) {
            arr[s.charAt(j)]++;
            //出现重复的字符
            if (arr[s.charAt(j)] == 2) {
                mutil++;
            }
            //当有重复的字符时
            if (mutil > 0) {
                while (mutil > 0 && i < j) {
                    //缩小串口大小
                    arr[s.charAt(i)]--;
                    //当前字符个数减少为1时
                    if (arr[s.charAt(i)] == 1) {
                        mutil--;
                    }
                    //继续缩小窗口
                    i++;
                }
            }
            //记录窗口的最小值
            maxLen = Math.max(maxLen, j - i + 1);
        }
        //输出最大长度
        return maxLen;
    }
}
