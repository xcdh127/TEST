package CodeDream;

/*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
提示:
1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母
*/
public class Test242 {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        //如果两个字符串长度不相等，直接返回false
        if (lenS != lenT) {
            return false;
        }
        //记录字母出现的次数
        int[] arr = new int[26];
        //s中的字符++
        for (int i = 0; i < lenS; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        //t中的字符--
        for (int i = 0; i < lenT; i++) {
            arr[t.charAt(i) - 'a']--;
        }
        //判断是否全为0
        return allZero(arr);
    }
    //判断数组中的数字是否全是0
    public boolean allZero(int[] arr) {
        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
