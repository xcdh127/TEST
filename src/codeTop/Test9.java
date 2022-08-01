package codeTop;
/*给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。
示例 1：
输入：x = 121
输出：true
示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
提示：
-231 <= x <= 231 - 1
进阶：你能不将整数转为字符串来解决这个问题吗？
*/
public class Test9 {
    public boolean isPalindrome(int x) {
        //负数直接返回false
        if (x<0){
            return false;
        }
        //数字转字符串
        String str=String.valueOf(x);
        //判断是否是回文
        return isHuiWen(str);
    }

    public boolean isHuiWen(String s){
        int n=s.length();
        int i=0;
        int j=n-1;
        //当i<j时
        while (i<j){
            //判断字符i与字符j是否相等
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            //i++
            i++;
            //j--
            j--;
        }
        //返回true
        return true;
    }
}
