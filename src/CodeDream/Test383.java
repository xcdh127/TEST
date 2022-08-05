package CodeDream;

/*给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。
示例 1：
输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：
输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：
输入：ransomNote = "aa", magazine = "aab"
输出：true
提示：
1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成
*/
public class Test383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int lenM = magazine.length();
        //记录magazine中的字符以及出现次数
        for (int i = 0; i < lenM; i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        int lenR = ransomNote.length();
        //ransomNote出现后个数-1
        for (int i = 0; i < lenR; i++) {
            arr[ransomNote.charAt(i) - 'a']--;
            //如果出现不能提供足够字符，返回false
            if (arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        //可以写出，返回true
        return true;
    }
}
