package TTT;

import java.util.ArrayList;
import java.util.List;
/*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，
返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
*/
public class Test19 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int m=s.length();
        int n=p.length();
        if(n>m){
            return list;
        }
        //存放26个字母出现的次数
        int[] arr=new int[26];
        //遍历p字符串的长度
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }
        //遍历完字符串p之后，如果数组中的字母个数都为0，就说明0位置开始是异位词
        if(isAllZero(arr)){
            list.add(0);
        }
        //s字符串进入窗口的部分+1，滑出窗口的部分-1
        for(int i=n;i<m;i++){
            arr[s.charAt(i-n)-'a']--;
            arr[s.charAt(i)-'a']++;
            //滑动过程中，如果数组中的个数全为0，记录数组中的位置
            if(isAllZero(arr)){
                list.add(i-n+1);
            }
        }
        return list;
    }
    public boolean isAllZero(int[] arr){
        for(int num : arr){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
