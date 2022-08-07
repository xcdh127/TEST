package CodeDream;

/*实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
示例 1：
输入：haystack = "hello", needle = "ll"
输出：2
示例 2：
输入：haystack = "aaaaa", needle = "bba"
输出：-1
提示：
1 <= haystack.length, needle.length <= 104
haystack 和 needle 仅由小写英文字符组成
*/
public class Test28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //创建next数组
        int[] next = new int[needle.length()];
        //填充next数组
        getNext(next, needle);
        //j指向0
        int j = 0;
        //遍历haystack数组
        for (int i = 0; i < haystack.length(); i++) {
            //当指针j大于等于0，并且j指针指向needle的字符不等于i指针指向haystack的字符时
            //j指针一直向前回退
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            //当j指针指向needle的字符等于i指针指向haystack的字符时，j++
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            //当j等于needle字符串的长度时，返回i指针-needle字符串的长度+1
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    //获取next数组
    public void getNext(int[] next, String s) {
        //j指向前缀的后面
        int j = 0;
        int n = next.length;
        next[0] = j;
        //i指向后缀的前面
        for (int i = 1; i < n; i++) {
            //当两个指针指向的字符不相等时，j回退到前一个位置
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            //当两个指针指向的字符相等时，j++
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //i位置为j
            next[i] = j;
        }
    }
}
