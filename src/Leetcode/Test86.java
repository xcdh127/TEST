package Leetcode;
/*给你两个字符串 word1 和 word2 。
请你从 word1 开始，通过交替添加字母来合并字符串。
如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
返回 合并后的字符串 。
*/
public class Test86 {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //两个指针分别指向两个字符串的开头
        int i=0;
        int j=0;
        //当有一个指针没有指向末尾时
        while (i<m || j<n){
            //当i指针遍历完字符串word2时，将word1剩余部分拼接进来
            if (i==m){
                sb.append(word2.charAt(j++));
            }
            //当j指针遍历完字符串word1时，将word2剩余部分拼进来
            else if (j==n){
                sb.append(word1.charAt(i++));
            }
            //分别将两个指针指向的字符拼接进来
            else {
                sb.append(word1.charAt(i++));
                sb.append(word2.charAt(j++));
            }
        }
        //返回结果
        return sb.toString();
    }
}
