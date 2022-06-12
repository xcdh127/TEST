package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
*/
public class Test103 {
    public String reformat(String s) {
        //存放数字
        List<Character> number=new ArrayList<>();
        //存放字母
        List<Character> letter=new ArrayList<>();
        int n=s.length() ;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))){
                number.add(s.charAt(i));
            }
            else {
                letter.add(s.charAt(i));
            }
        }
        //求两个数组的长度
        int numLen=number.size();
        int letLen=letter.size();
        //如果两个数组长度差大于1，返回false
        if(Math.abs(numLen-letLen)>1){
            return "";
        }
        //双指针
        int i=0;
        int j=0;
        StringBuilder sb=new StringBuilder();
        while (i<numLen && j<letLen){
            //长的数组先拼接进sb
            if (numLen>letLen){
                sb.append(number.get(i++));
                sb.append(letter.get(j++));
            }
            else {
                sb.append(letter.get(j++));
                sb.append(number.get(i++));
            }

        }
        //没有拼接完的数组继续拼接
        if (i<numLen){
            sb.append(number.get(i));
        }
        else if(j<letLen){
            sb.append(letter.get(j));
        }
        //输出结果
        return sb.toString();
    }
}
