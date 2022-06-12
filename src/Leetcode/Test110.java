package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
分组可以用区间 [start, end] 表示，其中 start 和
end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
*/
public class Test110 {
    public List<List<Integer>> largeGroupPositions(String s) {
        int n=s.length();
        //指向字符串首部的指针
        int start=0;
        //存放结果
        List<List<Integer>> res=new ArrayList<>();
        //存放长度大于等于3的连续字符串
        List<Integer> list=new ArrayList<>();
        while (start<n){
            //记录新字符首次出现的位置
            int newIndex=start;
            //取出当前字符
            char ch=s.charAt(start);
            //统计连续字符个数
            int count=0;
            while (start<n && s.charAt(start)==ch){
                start++;
                count++;
            }
            //当连续字符个数大于等于3个时，将起始下标添加到list中
            if (count>=3){
                list.add(newIndex);
                list.add(start-1);
                //将list放进结果中
                res.add(list);
                //刷新list
                list=new ArrayList<>();
            }
        }
        //返回结果
        return res;
    }
}
