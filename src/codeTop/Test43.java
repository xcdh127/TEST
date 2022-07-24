package codeTop;
/*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"
示例2:
输入: num1 = "123", num2 = "456"
输出: "56088"
提示：
1 <= num1.length, num2.length <= 200
num1 和 num2 只能由数字组成。
num1 和 num2 都不包含任何前导零，除了数字0本身。
*/
public class Test43 {
    public String multiply(String num1, String num2) {
        //当两个字符串有一个为0时，乘积就返回0
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m=num1.length();
        int n=num2.length();
        //m位数+n位数相加，结果最多为m+n位数
        int[] res=new int[m+n];
        //从第一个字符串的末尾开始，向前每一位都与第二个字符串开始逐位相乘
        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                //乘积结果记录在结果数组的i+j+1位置，i位置字符乘以j位置的字符
                res[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        //从结果数组的最后开始向前遍历结果数组
        for (int i = m+n-1; i >=1 ; i--) {
            //进位记录在i位置前一位上
            res[i-1]+=res[i]/10;
            //记录i位置上的数字
            res[i]%=10;
        }
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //初始化拼接字符串的起始位置为1
        int j=1;
        //当两个数字相加的位数为m+n时，res数组首位数字不为空时，将从0开始拼接字符串
        if (res[0]!=0){
            j=0;
        }
        //遍历结果字符串，拼接在字符串里
        for (; j<m+n; j++) {
            sb.append(res[j]);
        }
        //返回结果
        return sb.toString();
    }
}
/*class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m=num1.length();
        int n=num2.length();
        int[] arr=new int[m+n];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                // 123
                // 456
                //       4  8   12  5  10   15  6 12 18
                arr[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for(int i=m+n-1;i>=1;i--){
            arr[i-1]+=arr[i]/10;
            arr[i]%=10;
        }
        StringBuilder sb=new StringBuilder();
        int j=1;
        if(arr[0]!=0){
            j=0;
        }
        for(;j<m+n;j++){
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}*/