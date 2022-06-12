package Leetcode;
/*给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。
字符串由 n 个破折号分成 n + 1 组。你也会得到一个整数 k 。
我们想要重新格式化字符串 s，使每一组包含 k 个字符，
除了第一组，它可以比 k 短，但仍然必须包含至少一个字符。
此外，两组之间必须插入破折号，并且应该将所有小写字母转换为大写字母。
返回 重新格式化的许可密钥 。
*/

import javax.xml.stream.events.Characters;

/*输入：S = "5F3Z-2e-9-w", k = 4
输出："5F3Z-2E9W"
解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     注意，两个额外的破折号需要删掉。

输入：S = "2-5g-3-J", k = 2
输出："2-5G-3J"
解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。


*/
public class Test106 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("---", 3));
    }
    public static String licenseKeyFormatting(String s, int k) {
        //记录字符串的长度
        int n=s.length();
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //将字符串从后向前遍历，依次添加到sb中
        //记录每一部分单词的个数
        int num=k;
        for (int i = n-1; i >=0; i--) {
            //当字符串当前位置上的字符不是-时，将字符添加进sb中
            if (s.charAt(i)!='-'){
                //将字符转成大写字符后，添加到sb中
                sb.append(Character.toUpperCase(s.charAt(i)));
                //此时一组中的数字个数减少1
                num--;
                //当已经拼接了k个字符就将拼接进去一个连字符
                if (num==0){
                    sb.append("-");
                    //更新字符串的拼接个数
                    num=k;
                }
            }
        }
        //当原数字符串中没有字母时，直接输出空字符串
        if (sb.length()==0){
            return "";
        }
        if (sb.charAt(sb.length()-1)=='-'){
            sb.deleteCharAt(sb.length()-1);
        }
        //如果最后一个字符是'-'时,将最后一个-删除掉
        //将字符串逆序输出
        sb.reverse();
        //返回字符串结果
        return sb.toString();
    }
}
