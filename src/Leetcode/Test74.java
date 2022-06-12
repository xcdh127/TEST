package Leetcode;
/*给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
例如：
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
*/
public class Test74 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int columnNumber) {
        //用于拼接字符串
        StringBuilder sb=new StringBuilder();
        //当数字大于0时
        while (columnNumber>0){
            //下标从1开始计数，(用数字-1)%26+1得到余数
            int yuShu=(columnNumber-1)%26+1;
            //根据余数添加对应的字符进入字符串中
            sb.append((char)('A'+yuShu-1));
            //当前数字减掉余数，除26
            columnNumber=(columnNumber-yuShu)/26;
        }
        //反转字符串
        sb.reverse();
        //输出
        return sb.toString();
    }
}
//
//    public String convertToTitle(int columnNumber) {
//        StringBuffer sb = new StringBuffer();
//        while (columnNumber > 0) {
//            int a0 = (columnNumber - 1) % 26 + 1;
//            sb.append((char)(a0 - 1 + 'A'));
//            columnNumber = (columnNumber - a0) / 26;
//        }
//        return sb.reverse().toString();
//    }

