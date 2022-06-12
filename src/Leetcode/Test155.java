package Leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*给你一个表示某个正整数的字符串 number 和一个字符 digit 。
从 number 中 恰好 移除 一个 等于 digit 的字符后，
找出并返回按 十进制 表示 最大 的结果字符串。
生成的测试用例满足 digit 在 number 中出现至少一次。
*/
/*输入：number = "123", digit = "3"
输出："12"
解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。

输入：number = "1231", digit = "1"
输出："231"
解释：可以移除第一个 '1' 得到 "231" 或者移除第二个 '1' 得到 "123" 。
由于 231 > 123 ，返回 "231" 。

*/
public class Test155 {
    public String removeDigit(String number, char digit) {
        //存放所有的可以删掉当前字符的字符串
        List<String> list=new ArrayList<>();
        //遍历字符串number
        for (int i = 0; i < number.length(); i++) {
            //当字符串第i个字符等于digit时
            if (number.charAt(i)==digit){
                //将原字符串赋值一份
                StringBuilder sb=new StringBuilder(number);
                //删除掉第i位置的字符
                sb.deleteCharAt(i);
                //添加到字符串集合中
                list.add(sb.toString());
            }
        }
        //对字符串数组进行自定义排序
        Collections.sort(list,(a,b)->(compare(a,b)));
        return list.get(0);
    }
    //自定义排序规则
    public int compare(String s1,String s2){
        //如果字符串的长度相等，就逐位比较两个字符串的字符
        if (s1.length()==s2.length()){
            //将指针指向两个字符串的开头位置
            int index=0;
            //当字符串的第index位置的字符相同时，就继续将指针向后移动
            while (index<s1.length() && s1.charAt(index)==s2.charAt(index)){
                index++;
            }
            //如果没有对比到字符串的末尾时，就出现了两个字符对应不一致的字符
            //就比较当前两个字符的大小，按照字符的大小从大到小排序
            //长度相等按照字符数字值的大小排序
            if (index!=s1.length()){
                return s2.charAt(index)-s1.charAt(index);
            }
            //如果比较到最后一个字符时，两个字符仍然相同，说明此时两个字符相同
            //两个字符串相等，此时返回0
            else {
                return 0;
            }
        }
        //如果字符串的长度不相等就比较长度，字符串的长度长的字符串越大，按照
        //字符串的长度逆序排序
        else {
            return s2.length()-s1.length();
        }
    }
}
