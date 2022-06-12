package Leetcode;
/*给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
示例 1：
输入：s = "ilovecodingonleetcode", target = "code"
输出：2
解释：
对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
可以形成最多 2 个 "code" 的副本，所以返回 2 。
*/
public class Test286 {
    public int rearrangeCharacters(String s, String target) {

        int[] hash1=new int[26];
        int[] hash2=new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash1[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < target.length(); i++) {
            hash2[target.charAt(i)-'a']++;
        }
        int temp=Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (hash2[i]!=0){
                temp=Math.min(temp,hash1[i]/hash2[i]);
            }
        }
        return temp;
        /*int[] arr=new int[26];
        for (int i = 0; i < target.length(); i++) {
            arr[s.charAt(i)-'a']++;
            arr[target.charAt(i)-'a']--;
        }
        int count=0;
        if (allZero(arr)){
            count++;
        }
        for (int i = target.length(); i <s.length(); i++) {
            arr[s.charAt(i-target.length())-'a']--;
            arr[s.charAt(i)-'a']++;
            if (allZero(arr)){
                count++;
            }
        }
        return count;*/
    }

   /* public boolean allZero(int[] arr){
        for (int num : arr) {
            if (num!=0){
                return false;
            }
        }
        return true;
    }*/
}
