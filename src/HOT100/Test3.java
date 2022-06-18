package HOT100;
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
        int mutil=0;
        int n=s.length();
        int[] arr=new int[256];
        int i=0;
        int max=0;
        for (int j = 0; j < n; j++) {
            arr[s.charAt(j)]++;
            if (arr[s.charAt(j)]==2){
                mutil++;
            }
            while (mutil>0){
                arr[s.charAt(i)]--;
                if (arr[s.charAt(j)]==1){
                    mutil--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}
















