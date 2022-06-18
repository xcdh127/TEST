package HOT100;
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
        String res="";
        int start=0;
        int end=0;
        int n=s.length();
        int maxLen=0;
        for (int i = 0; i < n; i++) {
            int len1=maxLen(s,i,i);
            int len2=maxLen(s,i,i+1);
            int len=Math.max(len1,len2);
            if (len>maxLen){
                int maxStart=i-(len-1)/2;
                int maxEnd=i+(len/2);
                maxLen=len;
                res=s.substring(maxStart,maxEnd+1);
            }
        }
        return res;
    }

    public int maxLen(String s,int start,int end){
        int n=s.length();
        while (start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}


/*class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";
        int maxLen=0;
        for(int i=0;i<n;i++){
            int len1=getLen(s,i,i);
            int len2=getLen(s,i,i+1);
            int len=Math.max(len1,len2);
            if(maxLen<len){
                maxLen=len;
                int start=i-(maxLen-1)/2;
                int end=i+maxLen/2;
                res=s.substring(start,end+1);
            }
        }
        return res;
    }
    public int getLen(String s,int start,int end){
        while(end<s.length() && start>=0 && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}*/
