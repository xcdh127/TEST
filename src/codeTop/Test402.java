package codeTop;

import java.util.Deque;
import java.util.LinkedList;

/*给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
示例 1 ：
输入：num = "1432219", k = 3
输出："1219"
解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
示例 2 ：
输入：num = "10200", k = 1
输出："200"
解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 ：
输入：num = "10", k = 2
输出："0"
解释：从原数字移除所有的数字，剩余为空就是 0 。
提示：
1 <= k <= num.length <= 105
num 仅由若干位数字（0 - 9）组成
除了 0 本身之外，num 不含任何前导零
*/
public class Test402 {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        //双端队列
        Deque<Character> queue=new LinkedList<>();
        //遍历字符串中的字符
        for (int i = 0; i < n; i++) {
            //取出当前字符
            char number=num.charAt(i);
            //当前队列不为空，并且k大于0，并且队列的最后一个数字大于number时
            //将队列的最后一个字符弹出队列，并且将k--
            while (!queue.isEmpty() && k>0 && queue.peekLast()>number){
                queue.removeLast();
                k--;
            }
            //直到不满足条件，将当前字符添加到双端队列的末尾
            queue.addLast(number);
        }
        //如果没有删足k个字符，继续删除
        for (int i = 0; i < k; i++) {
            queue.removeLast();
        }
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //前导0标记
        boolean zero=true;
        //当队列不为空时
        while (!queue.isEmpty()){
            //处理当前字符
            char number=queue.removeFirst();
            //0标记为true，并且当前字符是'0'，跳过前导0
            if (zero && number=='0'){
                continue;
            }
            //没有前导0，将标记为false
            zero=false;
            //添加当前字符
            sb.append(number);
        }
        //字符长度为0，输出字符串0，否则输出字符串
        return sb.length()==0?"0":sb.toString();
    }
}
class Solution3 {
    public String removeKdigits(String num, int k) {

        int n=num.length();
        Deque<Character> queue=new LinkedList<Character>();

        for(int i=0;i<n;i++){

            char number=num.charAt(i);
            while(!queue.isEmpty() && k>0 && queue.peekLast()>number){

                queue.removeLast();
                k--;
            }
            queue.addLast(number);
        }

        //判断是否删除k个元素
        for(int i=0;i<k;i++){

            queue.removeLast();
        }

        StringBuilder sb=new StringBuilder();
        boolean zero=true;
        while(!queue.isEmpty()){
            char number=queue.removeFirst();

            if(zero && number=='0'){
                continue;
            }
            zero=false;

            sb.append(number);

        }
        return sb.length()==0?"0":sb.toString();
    }
}

