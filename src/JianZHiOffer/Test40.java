package JianZHiOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
限制：
1 <= s 的长度 <= 8
*/
public class Test40 {
    public String[] permutation(String s) {
        char[] ch=s.toCharArray();
        List<String> res=new ArrayList<>();
        recur(res,ch,0);
        String[] ans=new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i]=res.get(i);
        }
        return ans;
    }

    public void recur(List<String> list,char[] str,int index){
        if (index==str.length){
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                sb.append(str[i]);
            }
            list.add(sb.toString());
            return;
        }
        Set<Character> set=new HashSet<>();
        for (int i = index; i <str.length ; i++) {
            if (set.contains(str[i])){
                continue;
            }
            set.add(str[i]);
            swap(str,i,index);
            recur(list,str,index+1);
            swap(str,i,index);
        }
    }

    public void swap(char[] str,int a,int b){
        char temp=str[a];
        str[a]=str[b];
        str[b]=temp;
    }
}
