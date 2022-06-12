package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给你一个字符串 text ，该字符串由若干被空格包围的单词组成。
每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。
题目测试用例保证 text 至少包含一个单词 。
请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，
并尽可能 最大化 该数目。如果不能重新平均分配所有空格，
请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
返回 重新排列空格后的字符串 。
*/
public class Test88 {
    public String reorderSpaces(String text) {
        //字符串的长度
        int n=text.length();
        //统计字符串的空格数
        int countKongGe=0;
        //统计字符串中的单词个数
        int countWord=0;
        //记录字符串中的所有的单词
        List<String> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //如果当前字符是空格，就累加空格出现的次数
            if (text.charAt(i)==' '){
                countKongGe++;
            }
            //遇到是字母时
            else {
                //字母开始的位置
                int start=i;
                //当没有遍历到字符串的末尾 并且此时遇到的是字符时，将指针向后移动一位
                while (i<text.length() && Character.isLetter(text.charAt(i))){
                    i++;
                }
                //截取出这个字母
                list.add(text.substring(start,i));
                //将i指针向前移动一位
                i--;
                //记录此时的单词个数+1
                countWord++;
            }
        }
        //新建sb拼接字符串
        StringBuilder sb=new StringBuilder();
        //统计新的字符串中有多少个空格
        int kongGe=countWord-1;
        //当空格个数为0时，特殊处理
        if (kongGe==0){
            //首先将字符串拼接进去
            sb.append(list.get(0));
            //在拼接空格
            for (int i = 0; i < countKongGe; i++) {
                sb.append(" ");
            }
            //返回字符串
            return sb.toString();
        }
        //记录每一个空格区间有几个空格组成
        int perKongGe=countKongGe/kongGe;
        //遍历字符串数组
        for (int i = 0; i < list.size(); i++) {
            //当此时不是最后一个字符串时
            if (i!=list.size()-1){
                //将当前字符串拼接进sb中
                sb.append(list.get(i));
                //将空格拼接在字符串的后面，每拼接一个空格，将空格个数-1
                for (int j = 0; j < perKongGe; j++) {
                    sb.append(" ");
                    countKongGe--;
                }
            }
            //当最后一个字符串时，只拼接进字符串，不拼接空格
            else {
                sb.append(list.get(i));
            }
        }
        //当还有空格没有拼接进字符串时，将剩余空格都拼接进sb中
        while (countKongGe>0){
            sb.append(" ");
            countKongGe--;
        }
        //返回字符串
        return sb.toString();
    }
}
