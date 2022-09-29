package codetophuawei;

import java.util.ArrayList;
import java.util.List;

/*字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
示例：
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
提示：
S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
*/
public class Test763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int[] arr = new int[26];
        //记录字符串中每一个字符出现的最远的位置
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        //左边界
        int left = 0;
        //右边界
        int right = 0;
        //再次遍历字符串
        for (int i = 0; i < n; i++) {
            //right指向当前字符的最远距离
            right = Math.max(right, arr[s.charAt(i) - 'a']);
            //当前位置到达最远距离时
            if (right == i) {
                //将这个片段字符串的长度添加到结果中
                res.add(right - left + 1);
                //新的左边界为当前位置+1
                left = i + 1;
            }
        }
        //返回结果
        return res;
    }
}


class Solution150 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] arr = new int[26];
        List<Integer> list = new ArrayList<>();
        //记录每一个字符最远到达的位置
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, arr[s.charAt(i) - 'a']);
            if (right == i) {
                list.add(right - left + 1);
                left = i + 1;
            }
        }
        return list;
    }
}