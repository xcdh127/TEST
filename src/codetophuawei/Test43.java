package codetophuawei;

/*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
提示：
1 <= num1.length, num2.length <= 200
num1 和 num2 只能由数字组成。
num1 和 num2 都不包含任何前导零，除了数字0本身。
*/
public class Test43 {

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int cul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //这个位置i+j+1上的值累加
                res[i + j + 1] += cul;
            }
        }
        for (int i = m + n - 1; i >= 1; i--) {
            //处理进位
            res[i - 1] += res[i] / 10;
            //处理当前位置
            res[i] = res[i] % 10;
        }
        //从1位置开始向后拼接字符串
        int index = 1;
        //如果第一个位置不为0
        if (res[0] != 0) {
            //从0位置开始拼接字符串
            index = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < m + n; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}


class Solution121 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = m + n - 1; i >= 1; i--) {
            //进位
            res[i - 1] += res[i] / 10;
            //此位数字
            res[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        //初始化拼接字符串的起始位置为1
        int j = 1;
        //当res数组首位数字不为空时，将从0开始拼接字符串
        if (res[0] != 0) {
            j = 0;
        }
        for (; j < m + n; j++) {
            sb.append(res[j]);
        }
        return sb.toString();
    }
}