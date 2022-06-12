package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。
除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮
件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
例如 m.y+name@email.com 将转发到 my@email.com。
可以同时使用这两个规则。
给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
*/
public class Test96 {
    public static void main(String[] args) {
        String[] str=new String[]{"linqmafia@leet+code.com","linqmafia@code.com"};
        System.out.println(numUniqueEmails(str));
    }
    public static int numUniqueEmails(String[] emails) {
        //记录不同的邮箱地址
        Set<String> set=new HashSet<>();
        int n=emails.length;
        for (int i = 0; i < n; i++) {
            //取出当前邮箱
            String s=emails[i];
            //拼接字符串
            StringBuilder sb=new StringBuilder();
            //遍历所有的邮箱地址
            for (int j = 0; j < s.length(); j++) {
                //找到第一个@出现的位置
                int index=s.indexOf("@");
                //当.出现在域名时添加.
                if (j>index && s.charAt(j)=='.'){
                    sb.append('.');
                }
                //否则本地名忽略
                else if (j<index && s.charAt(j)=='.'){
                    continue;
                }
                //当+出现在本地名时，跳过之后的所有消息
                else if (j<index && s.charAt(j)=='+'){
                    j=index;
                    sb.append(s.charAt(j));
                }
                //否则当前字符添加进来
                else {
                    sb.append(s.charAt(j));
                }
            }
            //处理完成的字符串添加到set集合中
            set.add(sb.toString());
        }
        //返回set的大小
        return set.size();
    }
}
