package Leetcode;
/*给你一个仅由数字 6 和 9 组成的正整数 num。
你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
请返回你可以得到的最大数字。
示例 1：
输入：num = 9669
输出：9969
解释：
改变第一位数字可以得到 6669 。
改变第二位数字可以得到 9969 。
改变第三位数字可以得到 9699 。
改变第四位数字可以得到 9666 。
其中最大的数字是 9969 。
*/
public class Test276 {
    public int maximum69Number (int num) {
        String numStr=String.valueOf(num);
        StringBuilder sb=new StringBuilder();
        boolean isChange=false;
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i)=='6' && !isChange){
                sb.append('9');
                isChange=true;
            }
            else {
                sb.append(numStr.charAt(i));
            }
        }
        return Integer.valueOf(sb.toString());
    }
}
