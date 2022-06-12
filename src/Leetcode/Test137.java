package Leetcode;
/*给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，
如果不存在第二大的数字，请你返回 -1 。混合字符串 由小写英文字母和数字组成。*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*输入：s = "dfa12321afd"
输出：2
解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。*/
public class Test137 {
    public int secondHighest(String s) {
        int n=s.length();
        //存放数字的数组
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //如果当前位置上的字符是数字，就将当前数字添加到数组中
            if (Character.isDigit(s.charAt(i))){
                list.add(s.charAt(i)-'0');
            }
        }
        //对数字排序
        Collections.sort(list);
        //如果数组中的数字个数等于1时，直接返回-1
        if (list.size()<=1){
            return -1;
        }
        //设置第二大的数字为-1
        int res=-1;
        //取出数组中最大的数字
        int maxValue=list.get(list.size()-1);
        //从数组的倒数第二位值遍历数组
        int index=list.size()-2;
        //遍历所有数组中的所有数字
        while (index>=0){
            //当数组中存在第二大的数字时
            if (list.get(index)<maxValue){
                //此值就是数组中第二大的数字
                res=list.get(index);
                break;
            }
            //将指针向前指向
            index--;
        }
        //返回当前数字
        return res;
    }
}
