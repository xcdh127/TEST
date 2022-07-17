package codeTop;
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
        int n=s.length();
        //arr数组记录所有的字符及其出现的次数
        int[] arr=new int[256];
        //重复次数
        int mutil=0;
        //左窗口
        int i=0;
        //右窗口
        int j=0;
        //记录最大长度
        int maxLen=0;
        //当没有遍历完字符串时，窗口继续向后滑动
        while (j<n){
            //将进入窗口的字符个数+1
            arr[s.charAt(j)]++;
            //当窗口中当前字符的个数等于2时，重复字符的个数+1
            if (arr[s.charAt(j)]==2){
                mutil++;
            }
            //当重复字符串的个数大于0时，缩小窗口，在缩小窗口的过程中，如果窗口右边界字符个数等于1，mutil--
            //缩小窗口的大小
            while (mutil>0){
                arr[s.charAt(i)]--;
                if (arr[s.charAt(j)]==1){
                    mutil--;
                }
                i++;
            }
            //在窗口滑动过程中记录字符串最大长度
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        //返回最大长度
        return maxLen;
    }
}
