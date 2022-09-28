package codetophuawei;

/*给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
在执行上述操作后，返回包含相同字母的最长子字符串的长度。
示例 1：
输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：
输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
提示：
1 <= s.length <= 105
s 仅由大写英文字母组成
0 <= k <= s.length
*/
public class Test424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] chars = s.toCharArray();
        //滑动窗口左边界
        int left = 0;
        //滑动窗口右边界
        int right = 0;
        int maxCount = 0;
        //记录窗口内数字出现的次数
        int[] freq = new int[26];
        //记录最大长度
        int res = 0;
        //当没有到达字符的末尾时
        while (right < len) {
            //滑进窗口，字符个数+1
            freq[chars[right] - 'A']++;
            //记录滑动窗口中出现频次最高的次数
            maxCount = Math.max(maxCount, freq[chars[right] - 'A']);
            //扩大窗口大小
            right++;
            //当窗口大小大于窗口内出现频次最高的字符出现的次数+k时，说明此时k已经不够用了，需要缩小窗口
            //maxCount+k的长度不足够此时的窗口大小，窗口内的字符不都一样，此时缩小窗口大小
            if (right - left > maxCount + k) {
                //缩小窗口大小，将左窗口出的字符出现次数-1
                freq[chars[left] - 'A']--;
                left++;
            }
            //记录最大窗口的长度
            res = Math.max(res, right - left);
        }
        //返回最大长度
        return res;
    }
}


class Solution129 {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len) {
            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}

