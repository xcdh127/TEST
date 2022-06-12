package Leetcode;
/*给你一个字符串 s ，请你根据下面的算法重新构造字符串：
1从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
2从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
3重复步骤 2 ，直到你没法从 s 中选择字符。
4从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
5从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
6重复步骤 5 ，直到你没法从 s 中选择字符。
7重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
请你返回将 s 中字符重新排序后的 结果字符串 。
*/
public class Test118 {
    public String sortString(String s) {
        int[] arr=new int[26];
        //将字符串中字符信息添加到数组中
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        //拼接字符串
        StringBuilder res=new StringBuilder();
        while (res.length()<s.length()){
            //从前向后向字符串中拼接字符
            for (int i = 0; i < 26; i++) {
                //如果当前字符还有没有被访问过的元素
                if (arr[i]>0){
                    //向res中添加当前字符
                    res.append((char)(i+'a'));
                    arr[i]--;
                }
            }
            //从后向前向字符串中拼接字符
            for (int i = 25; i >=0 ; i--) {
                //如果当前字符还有没有被访问过的元素
                if (arr[i]>0){
                    //向res中添加当前字符
                    res.append((char)(i+'a'));
                    arr[i]--;
                }

            }
        }
        //返回结果
        return res.toString();
    }
}

/*class Solution {
    public String sortString(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer ret = new StringBuffer();
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();
    }
}
*/

