package codeTop;
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
        int m=num1.length();
        int n=num2.length();
        //记录和
        int sum=0;
        //记录进位信息
        int carry=0;
        //分别指向两个字符串的末尾
        int i=m-1;
        int j=n-1;
        //存储字符串
        StringBuilder sb=new StringBuilder();
        while (i>=0 || j>=0){
            //取当前两个数字的加数
            int sumA=i>=0?num1.charAt(i)-'0':0;
            int sumB=j>=0?num2.charAt(j)-'0':0;
            //和为加数与余数的和
            sum=sumA+sumB+carry;
            //获取进位
            carry=sum>=10?1:0;
            //获取当前位置的和
            sum=sum>=10?sum-10:sum;
            //放进字符串里
            sb.append(sum);
            //指针分别向字符串的头指向一位，直到都指向头为止
            i--;
            j--;
        }
        //如果最后一位需要进位，就进位
        if (carry==1){
            sb.append(1);
        }
        //反转输出结果
        return sb.reverse().toString();
    }
}
