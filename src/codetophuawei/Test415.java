package codetophuawei;

/*给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
示例 1：
输入：num1 = "11", num2 = "123"
输出："134"
示例 2：
输入：num1 = "456", num2 = "77"
输出："533"
示例 3：
输入：num1 = "0", num2 = "0"
输出："0"
提示：
1 <= num1.length, num2.length <= 104
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
*/
public class Test415 {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        //将指针指向两个字符串的末尾
        int i = m - 1;
        int j = n - 1;
        //和
        int sum = 0;
        //进位信息
        int carry = 0;
        //拼接结果字符串
        StringBuilder sb = new StringBuilder();
        //当两个指针没有指向字符串的起始位置时
        while (i >= 0 || j >= 0) {
            //拿到当前两个字符
            int numA = i >= 0 ? num1.charAt(i) - '0' : 0;
            int numB = j >= 0 ? num2.charAt(j) - '0' : 0;
            //求和
            sum = numA + numB + carry;
            //处理进位
            carry = sum >= 10 ? 1 : 0;
            //处理此位和
            sum = sum >= 10 ? sum - 10 : sum;
            //将将此位和放进字符串中
            sb.append(sum);
            //当两个指针没有指向字符串的开头位置时，指针向前移位
            if (i >= 0) {
                i--;
            }
            if (j >= 0) {
                j--;
            }
        }
        //处理最后一位的进位信息
        if (carry == 1) {
            sb.append(1);
        }
        //将字符串反转，输出字符串
        return sb.reverse().toString();
    }
}
