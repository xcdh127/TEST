package Leetcode;
/*给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
该整数是 num 的一个长度为 3 的 子字符串 。
该整数由唯一一个数字重复 3 次组成。
以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
注意：
子字符串 是字符串中的一个连续字符序列。
num 或优质整数中可能存在 前导零 。
示例 1：
输入：num = "6777133339"
输出："777"
解释：num 中存在两个优质整数："777" 和 "333" 。
"777" 是最大的那个，所以返回 "777" 。
*/
public class Test283 {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
    }
    public static String largestGoodInteger(String num) {
        String res="";
        int n=num.length();
        for (int i = 2; i <n ; i++) {
            if (isSame(num,i-2,i-1,i)){
                if (!res.equals("") && Integer.parseInt(num.substring(i-2,i+1))>Integer.parseInt(res)){
                    res=num.substring(i-2,i+1);
                }
                if (res.equals("")){
                    res=num.substring(i-2,i+1);
                }
            }
        }
        return res;
    }

    public static boolean isSame(String s,int a,int b,int c){
        if (s.charAt(a)==s.charAt(b) && s.charAt(b)==s.charAt(c)){
            return true;
        }
        return false;
    }
}
