package Leetcode;
/*给你一个二进制字符串 s ，该字符串 不含前导零 。
如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
*/
//1001
public class Test136 {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        //两个指针一个指向1一个指向0
        int i=0;
        int j=n-1;
        //i指向1，直到指到一个0或者到达字符串的末尾
        while (i<n && s.charAt(i)=='1'){
            i++;
        }
        //i指向0，直到直到一个1或者达到字符串的末尾
        while (j>=0 && s.charAt(j)=='0'){
            j--;
        }
        //返回j指针是否指向i指针的前面
        return j+1==i;
    }
}
