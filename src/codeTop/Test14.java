package codeTop;
/*编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
提示：
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
*/
public class Test14 {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        //确定一个字符串为基准，找这个字符串与后面每一个字符串的公共部分
        String res=strs[0];
        for (String s :strs) {
            res=getUnion(res,s);
        }
        //返回所有字符串公共部分的字符串
        return res;
    }

    public String getUnion(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int i=0;
        int j=0;
        //当两个指针没有到达字符串的末尾，并且两个字符串值相等时，继续向后遍历字符串
        while (i<m && j<n && s1.charAt(i)==s2.charAt(j)){
            i++;
            j++;
        }
        //截取出两个字符串的公共部分
        return s1.substring(0,i);
    }
}
