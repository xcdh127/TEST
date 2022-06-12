package Leetcode;

import java.util.*;

/*给出 字符串 text 和 字符串列表 words,
返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]...text[j]
（包括 i 和 j）属于字符串列表 words。
*/
public class Test67 {
    public int[][] indexPairs(String text, String[] words) {
        //存放所有的字符串列表
        Set<String> set=new HashSet<>();
        for (String s :words) {
            set.add(s);
        }
        //存放截取字串在set中的i，j下标
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                String subString=text.substring(i,j+1);
                if (set.contains(subString)){
                    list.add(new int[]{i,j});
                }
            }
        }
        //转数组
        int[][] res=list.toArray(new int[list.size()][2]);
        //排序
        Arrays.sort(res,(a,b)->{
            //先按第一个字段排序
            if (a[0]!=b[0]){
                return a[0]-b[0];
            }
            //第一个字段相等，按照第二个字段排序
            else {
                return a[1]-b[1];
            }
        });
        //返回结果
        return res;
    }
}
