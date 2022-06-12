package Leetcode;
/*你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：
首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，
将数字 1  变成字母 I 。
如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，
那么我们就认为这个转换是有效的。
给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，
请返回转换后的结果，否则返回 "ERROR" 。
*/
public class Test116 {
    public String toHexspeak(String num) {
        //将字符串转换成long类型的数字
        long number=Long.parseLong(num);
        //将此数字转换成16进制字符串
        String hex=Long.toHexString(number);
        int n=hex.length();
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //遍历16进制字符串
        for (int i = 0; i < n; i++) {
            //如果当前字符合法
            if (isValid(hex.charAt(i))){
                //当字符为0时，将大写的O拼接字符串
                if (hex.charAt(i)=='0'){
                    sb.append('O');
                }
                //如果字符为1，将大写的I拼接字符串
                else if(hex.charAt(i)=='1'){
                    sb.append('I');
                }
                //否则将字母转大写拼接字符串
                else {
                    sb.append(Character.toUpperCase(hex.charAt(i)));
                }
            }
            //如果不合法，直接返回错误
            else {
                return "ERROR";
            }
        }
        //输出结果
        return sb.toString();

    }
    //字符在'2'~'9'之间非法，否则合法
    public boolean isValid(char ch){
        return !(ch>='2' && ch<='9');
    }
}
