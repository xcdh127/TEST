package CodeTop02;

import java.util.ArrayList;
import java.util.List;

/*有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.'
来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
示例 1：
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：
输入：s = "0000"
输出：["0.0.0.0"]
示例 3：
输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
提示：
1 <= s.length <= 20
s 仅由数字组成
*/
public class Test93 {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        return new ArrayList<>();


    }
}


class Solution68 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recur(res, s, "", "", 0, 0);
        return res;
    }

    public void recur(List<String> res, String s, String curIp, String partStr, int partId, int index) {
        if (partId == 3 && isVaild(partStr) && index == s.length()) {
            res.add(curIp + partStr);
        } else if (index < s.length()) {
            //拿到当前字符
            char ch = s.charAt(index);
            //新开一组数据
            //当前数据段少于4个并且之前那段有数据
            //将当前端拼进总ip地址，当前字符新成一段数字，段数+1，指针向后指一位
            if (partId < 3 && partStr.length() > 0) {
                recur(res, s, curIp + partStr + ".", ch + "", partId + 1, index + 1);
            }
            //将当前字符串拼接到当前段的末尾
            //先判断当前字段，拼接当前字符后是否合法
            //合法则拼接进来，字段id不变，指针向后指向一位
            if (isVaild(partStr + ch + "")) {
                recur(res, s, curIp, partStr + ch + "", partId, index + 1);
            }
        }
    }

    public boolean isVaild(String s) {
        //当前数字为0开头的非0数字 或者数字超过255，直接返回false
        if (s.charAt(0) == '0' && s.length() > 1 || Integer.valueOf(s) > 255) {
            return false;
        }
        return true;
    }
}