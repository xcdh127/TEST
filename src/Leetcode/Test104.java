package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：
给你一个字符串 currentState ，其中只含 '+' 和 '-' 。
你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，
返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表 [] 。
*/
/*输入：currentState = "++++"
输出：["--++","+--+","++--"]*/
public class Test104 {
    public List<String> generatePossibleNextMoves(String currentState) {
        //存放所有可能的修改字符串
        List<String> res=new ArrayList<>();
        int n=currentState.length();
        //从第二个字符开始向后遍历字符串，当前后两个字符串同时是+时，将连续+修改为连续-号
        for (int i = 1; i < n; i++) {
            if (currentState.charAt(i-1)=='+' && currentState.charAt(i)=='+'){
                res.add(replace(currentState,i));
            }
        }
        //返回结果
        return res;
    }
    //将字符串中的连续两个正号修改成两个负号
    public String replace(String currentState,int index){
        StringBuilder sb=new StringBuilder(currentState);
        sb.setCharAt(index,'-');
        sb.setCharAt(index-1,'-');
        return sb.toString();
    }

}
