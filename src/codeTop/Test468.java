package codeTop;

/*给定一个字符串queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中0 <= xi<= 255且xi不能包含 前导零。例如:“192.168.1.1”、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
一个有效的IPv6地址是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
1 <= xi.length <= 4
xi是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
在xi中允许前导零。
例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
示例 1：
输入：queryIP = "172.16.254.1"
输出："IPv4"
解释：有效的 IPv4 地址，返回 "IPv4"
示例 2：
输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
输出："IPv6"
解释：有效的 IPv6 地址，返回 "IPv6"
示例 3：
输入：queryIP = "256.256.256.256"
输出："Neither"
解释：既不是 IPv4 地址，又不是 IPv6 地址
提示：
queryIP 仅由英文字母，数字，字符 '.' 和 ':' 组成。
*/
public class Test468 {
    public String validIPAddress(String queryIP) {
        //如果是ipv4，就返回ipv4
        if(isIPv4(queryIP)){
            return "IPv4";
        }
        //如果是ipv6，就返回ipv6
        else if(isIPv6(queryIP)){
            return "IPv6";
        }
        //如果两者都不是，返回"Neither"
        else{
            return "Neither";
        }
    }

    public boolean isIPv4(String queryIP) {
        //取到当前要查询的ip
        int n = queryIP.length();
        //计数
        int count = 0;
        //记录当前数字
        int num = 0;
        //记录前一个字符'.'
        char prev = '.';
        //遍历当前字符串
        for (int i = 0; i < n; i++) {
            //取出当前字符串的字符
            char cur = queryIP.charAt(i);
            //判断当前字符是不是数字
            if (Character.isDigit(cur)) {
            //如果当前数字为0，并且前一个字符也是0时返回false,ipv4字符串不能有前导0
                if (num == 0 && prev == '0') {
                    return false;
                }
                //更新当前数字的值
                num = num * 10 + (cur - '0');
                //如果数字大于255时，返回false
                if (num > 255) {
                    return false;
                }
            }
            //当前位置上的字符是'.'时，并且前一个位置上的字符也是'.'，返回false
            else if (cur == '.') {
                if (prev == '.') {
                    return false;
                }
                //统计数组区域个数+1
                count++;
                //记录数字归零
                num = 0;
            }
            //遇到其他的字符，返回false
            else {
                return false;
            }
            //前一个prev字符指向当前cur字符
            prev = cur;
        }
        //统计数组区域个数+1
        count++;
        //如果数据区域等于4，并且数字小于等于255，并且前一个字符不是'.'
        return count == 4 && num <= 255 && prev != '.';
    }

    public boolean isIPv6(String queryIP){
        int n=queryIP.length();
        int count=0;
        //记录每一块数据的长度
        int partLength=0;
        //前一个位置为':'
        char prev=':';
        //遍历字符串
        for(int i=0;i<n;i++){
            //取出当前字符
            char cur=queryIP.charAt(i);
            //判断当前字符是否是16进制字符
            if(isHex(cur)){
                //当前块数字长度+1
                partLength++;
                //当前块数字的长度大于4时，返回false
                if(partLength>4){
                    return false;
                }
            }
            //当前字符是':'时
            else if(cur==':'){
                //当前一个字符也是':'时，返回false
                if(prev==':'){
                    return false;
                }
                //当前块数字长度+1
                count++;
                //更新当前数字的长度
                partLength=0;
            }
            //返回false
            else{
                return false;
            }
            //前一个字符指向当前字符
            prev=cur;
        }
        //块数+1
        count++;
        //块数等于8时，并且前一个字符不为':'
        return count==8 && prev!=':';
    }
    //判断是否是16进制字符
    public boolean isHex(char ch){
        //当前字符是数字，或者当前字符是小写字母，并且当前字符小于等于'f',或者当前字符是大写字母，或者当前字符小于等于'F'
        return Character.isDigit(ch) || Character.isLowerCase(ch) && ch<='f' || Character.isUpperCase(ch) && ch<='F';
    }
}
/*class Solution {
public String validIPAddress(String queryIP) {
if(isIPv4(queryIP)){
return "IPv4";
}
else if(isIPv6(queryIP)){
return "IPv6";
}
else{
return "Neither";
}
}
public boolean isIPv4(String queryIP){
int n=queryIP.length();
int count=0;
int num=0;
char prev='.';
for(int i=0;i<n;i++){
char cur=queryIP.charAt(i);
if(Character.isDigit(cur)){
//如果当前数字为0，并且前一个字符也是0时返回false
if(num==0 && prev=='0'){
return false;
}
num=num*10+(cur-'0');
if(num>255){
return false;
}
}
else if(cur=='.'){
if(prev=='.'){
return false;
}
count++;
num=0;
}
else{
return false;
}
prev=cur;
}
count++;
return count==4 && num<=255 && prev!='.';
}

public boolean isIPv6(String queryIP){
int n=queryIP.length();
int count=0;
int partLength=0;
char prev=':';
for(int i=0;i<n;i++){
char cur=queryIP.charAt(i);
if(isHex(cur)){
partLength++;
if(partLength>4){
return false;
}
}
else if(cur==':'){
if(prev==':'){
return false;
}
count++;
partLength=0;
}
else{
return false;
}
prev=cur;
}
count++;
return count==8 && prev!=':';
}
//判断是否是16进制字符
public boolean isHex(char ch){
return Character.isDigit(ch) || Character.isLowerCase(ch) && ch<='f' || Character.isUpperCase(ch) && ch<='F';
}
}*/
