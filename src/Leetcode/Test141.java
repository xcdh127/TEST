package Leetcode;
/*给你一个二进制字符串 s 。如果字符串中由 1 组成的
最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，
由 0 组成的最长连续子字符串的长度是 3 。
注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。
字符串中不存在 1 的情况也适用此规则。
*/
public class Test141 {
    public boolean checkZeroOnes(String s) {
        int n=s.length();
        //统计最长连续1的个数
        int maxLenOne=0;
        //统计最长连续0的个数
        int maxLenZero=0;
        //初始化指针
        int index=0;
        if (s.equals("1"))return true;
        while (index<n){
            //拿到当前字符，判断是0还是1
            char ch=s.charAt(index);
            //取到当前字符的位置
            int curIndex=index;
            //如果当前字符是0，并且没有遍历到字符串的末尾时，继续向后遍历字符串
            if (ch=='0'){
                while (index<n && s.charAt(index)=='0'){
                    index++;
                }
                //记录最大连续0的最大长度
                maxLenZero=Math.max(maxLenZero,index-curIndex-1);
            }
            //如果当前字符是1，并且没有遍历到字符串的末尾时
            else {
                while (index<n && s.charAt(index)=='1'){
                    index++;
                }
                //记录最大连续1的最大长度
                maxLenOne=Math.max(maxLenOne,index-curIndex-1);
            }
        }
        //返回最大连续1是否大于最大连续0的个数
        return maxLenOne>maxLenZero;
    }
}
