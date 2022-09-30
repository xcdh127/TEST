package codetophuawei;

/*给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。

 

示例 1：

输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
输出：16
解释：这两个单词为 "abcw", "xtfn"。
示例 2：

输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
输出：4
解释：这两个单词为 "ab", "cd"。
示例 3：

输入：words = ["a","aa","aaa","aaaa"]
输出：0
解释：不存在这样的两个单词。
 

提示：

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] 仅包含小写字母

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-product-of-word-lengths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Test318 {
    public int maxProduct(String[] words) {
        int maxValue = 0;
        int n = words.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (char ch : words[i].toCharArray()) {
                //用一个整型数字，记录一个单词包含26个字符的情况
                arr[i] |= 1 << (ch - 'a');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //当两个字符串没有公共字符，就是数字相与为0，记录最大值
                if ((arr[i] & arr[j]) == 0) {
                    maxValue = Math.max(words[i].length() * words[j].length(), maxValue);
                }
            }
        }
        return maxValue;
    }
}


class Solution {
    public int maxProduct(String[] words) {

        int n = words.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            for (char ch : words[i].toCharArray()) {
                arr[i] |= 1 << (ch - 'a');
            }

        }
        int maxMutil = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if ((arr[i] & arr[j]) == 0) {
                    maxMutil = Math.max(maxMutil, words[i].length() * words[j].length());
                }
            }
        }
        return maxMutil;
    }
}
