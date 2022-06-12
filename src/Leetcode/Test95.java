package Leetcode;
/*给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
*/
public class Test95 {
    public String defangIPaddr(String address) {
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //遍历字符串每一个字符
        for (int i = 0; i < address.length(); i++) {
            //如果字符串中的字符为'.'替换成[.]
            if (address.charAt(i)=='.'){
                sb.append("[.]");
            }
            //否则原样输出
            else {
                sb.append(address.charAt(i));
            }
        }
        //返回结果
        return sb.toString();
    }

}
