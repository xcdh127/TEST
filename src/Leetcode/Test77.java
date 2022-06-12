

package Leetcode;
/*给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 */
public class Test77 {
    public String thousandSeparator(int n) {
        //获取当前数字的字符串形式
        String s=String.valueOf(n);
        //长度
        int len=s.length();
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //记录数量为3
        int count=3;
        //从尾向前遍历字符串
        for (int i = len-1; i >=0; i--) {
            count--;
            //将当前字符添加到sb中
            sb.append(s.charAt(i));
            //当前计数为0时，将小数点添加到sb中
            //并将当前统计数字改变为3
            if (count==0){
                sb.append(".");
                count=3;
            }
        }
        //当最后一个字符是'.'时，将其删除
        if (sb.charAt(sb.length()-1)=='.'){
            sb.deleteCharAt(sb.length()-1);
        }
        //反转字符串
        sb.reverse();
        //输出字符串
        return sb.toString();
    }
}
