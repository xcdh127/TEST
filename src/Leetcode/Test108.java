package Leetcode;
/*RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。
例如，"#15c" 其实是 "#1155cc" 的简写。
现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，
则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2 来计算
那么给你一个按 "#ABCDEF" 形式定义的字符串 color 表示 RGB 颜色，、
请你以字符串形式，返回一个与它相似度最大且可以简写的颜色。（比如，可以表示成类似 "#XYZ" 的形式）
任何 具有相同的（最大）相似度的答案都会被视为正确答案。
*/
public class Test108 {
    public static void main(String[] args) {

    }
    public String similarRGB(String color) {
        //每一部分的最接近，就是答案
        return "#"+f(color.substring(1,3))+f(color.substring(3,5))+f(color.substring(5));
    }


    public String f(String comp){
        //将字符串从16进制转换成10进制
        int decComp=Integer.parseInt(comp,16);
        //将当前数字对17整除
        int integral=decComp/17;
        //将当前数字对17求余数
        int remainder=decComp%17;
        int muti;
        //如果余数大于8,说明此时数字更靠进下一个数字
        if (remainder>8){
            muti=integral+1;
        }
        //如果余数小于8
        else {
            muti=integral;
        }
        //将17乘回来
        int decRes=muti*17;
        //将求得的结果转换成16进制
        String hexRes=String.format("%02x",decRes);
        return hexRes;
    }

}

/*class Solution {
        public String similarRGB(String color) {
        // color = "#XXYYZZ"
        return "#" +
                f(color.substring(1, 3)) +  // XX
                f(color.substring(3, 5)) +  // YY
                f(color.substring(5));  // ZZ
    }

    public String f(String comp) {
        int decComp = Integer.parseInt(comp, 16); // 16 进制转 10 进制
        int integral = decComp / 17;    // 整数值
        int remainder = decComp % 17;   // 余数值
        int multiple;
        if (remainder > 8) {
            multiple = integral + 1;
        } else {
            multiple = integral;
        }
        int decResult = multiple * 17; // 前面除以 17，现在乘回来
        String hexResult = String.format("%02x", decResult);    // 转成16进制字符串
        return hexResult;
    }
}
*/
