package Leetcode;
/*给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
请你按下述方式重新格式化电话号码。
首先，删除 所有的空格和破折号。
其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
2 个数字：单个含 2 个数字的块。
3 个数字：单个含 3 个数字的块。
4 个数字：两个分别含 2 个数字的块。
最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，
并且 最多 生成两个含 2 个数字的块。
返回格式化后的电话号码。
*/
public class Test130 {
    public static void main(String[] args) {
        String s="123 4-5678";
        System.out.println(reformatNumber(s));
    }
    public static String reformatNumber(String number) {
        StringBuilder sb=new StringBuilder();
        //将所有数字拼接在字符串中
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))){
                sb.append(number.charAt(i));
            }
        }
        String str=sb.toString();
        int len=str.length();
        //指向字符串的开头位置
        int index=0;
        //123456
        //如果字符串个数大于4个
        StringBuilder res=new StringBuilder();
        while (len-index>4){
            //三个一组拼接字符串
            res.append(str.substring(index,index+3)+"-");
            index=index+3;
        }
        //数字长度等于4
        if (len-index==4){
            res.append(str.substring(str.length()-4,str.length()-2)+"-"+str.substring(str.length()-2,str.length()));
        }
        //数字长度等于3
        else if (len-index==3){
            res.append(str.substring(str.length()-3,str.length()));
        }
        //数字长度等于2
        else {
            res.append(str.substring(str.length()-2,str.length()));
        }
        return res.toString();
    }
}
