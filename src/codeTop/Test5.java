package codeTop;
/*给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成
*/
public class Test5 {
    public String longestPalindrome(String s) {
        int n=s.length();
        //记录最大回文字符串起始位置
        int maxStart=0;
        //记录最大回文字符串末尾位置
        int maxEnd=0;
        //记录最大长度
        int maxLen=0;
        //记录最长回文字符串结果
        String res="";
        for (int i = 0; i < n; i++) {
            //以一个字母向两端扩展，计算奇数长度字符串的长度
            int len1=countLen(s,i,i);
            //以两个字母向两端扩展，计算偶数长度字符串的长度
            int len2=countLen(s,i,i+1);
            //计算最长回文字符串的长度
            int len=Math.max(len1,len2);
            //如果当前回文字符串的长度大于字符串的最大长度，就更新res以及最大回文字符串长度
            if (len>maxLen){
                //此时最长字符串的起始位置
                maxStart=i-(len-1)/2;
                //最长字符串的末尾位置
                maxEnd=i+len/2;
                //截取最长回文字符串
                res=s.substring(maxStart,maxEnd+1);
                //更新最长回文子字符串的长度
                maxLen =len;
            }
        }
        //返回结果
        return res;
    }
    //计算从中间向两端扩展的回文子字符串的长度
    public int countLen(String s,int start,int end){
        int n=s.length();
        //当start没有到字符串的开头位置，并且end没有到达字符串的末尾位置，并且字符串start和end两个位置
        //上的字符是相等的，就继续向两端扩展
        while (start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        //返回此时形成字符串的长度
        return end-start-1;
    }
}
