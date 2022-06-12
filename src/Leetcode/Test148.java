package Leetcode;
/*给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
*/
public class Test148 {
    public boolean areOccurrencesEqual(String s) {
        int n=s.length();
        //统计字母出现的次数
        int[] arr=new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++;
        }
        return isEquals(arr);
    }
    //辅助判断每个字符个数是否相等
    private boolean isEquals(int[] arr){
        int num=-1;
        for (int n : arr) {
            if (num!=-1 && n!=0){
                if (n!=num){
                    return false;
                }
            }
            else if (num==-1 && n!=0){
                num=n;
            }
        }
        return true;
    }
}
