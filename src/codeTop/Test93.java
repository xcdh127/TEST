package codeTop;

import java.util.ArrayList;
import java.util.List;

/*有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
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
        List<String> res=new ArrayList<>();
        recur(res,s,"","",0,0);
        return res;

    }
    public void recur(List<String> res,String s,String curIp,String partStr,int partId,int index){
        //当此时ip段值为3，并且当前这段字符串有效，并且index到达了字符串的末尾
        if (partId==3 && isValid(partStr) && index==s.length()){
            //将拼接好的ip地址添加到结果中
            res.add(curIp+partStr);
        } else if (index < s.length()) {
            //取到当前字符
            char ch=s.charAt(index);
            //当partStr有内容时，才能作为新的ip地址的一段
            //作为新的区间,partId+1,上一段为curIp+partStr+.,新一段为ch
            if (partId<3 && partStr.length()>0){
                recur(res,s,curIp+partStr+".",ch+"",partId+1,index+1);
            }
            //拼接在原字符串的末尾,保持partId，当partStr+ch+""是合法的字符串时
            if (isValid(partStr+ch+"")){
                recur(res,s,curIp,partStr+ch+"",partId,index+1);
            }
        }
    }

    public boolean isValid(String s){
        //当字符串长度大于1并且是前缀0，或者字符串值大于255，就是非法数字
        if (s.charAt(0)=='0' && s.length()>1 || Integer.valueOf(s)>255){
            return false;
        }
        return true;
    }
}

class Solution2 {
    public List<String> restoreIpAddresses(String s) {

        List<String> res=new ArrayList<String>();
        recur(res,s,"","",0,0);
        return res;

    }

    public void recur(List<String> res,String s,String curIp,String partStr,int partId,int index){

        if(partId==3 && isValid(partStr) && index==s.length()){

            res.add(curIp+partStr);

        }
        else if(index<s.length()){

            char ch=s.charAt(index);
            if(partId<3 && partStr.length()>0){


                recur(res,s,curIp+partStr+".",ch+"",partId+1,index+1);


            }

            if(isValid(partStr+ch+"")){

                recur(res,s,curIp,partStr+ch+"",partId,index+1);

            }
        }

    }


    public boolean isValid(String s){


        if(s.charAt(0)=='0' && s.length()>1 || Integer.valueOf(s)>255){

            return false;
        }

        return true;
    }
}

