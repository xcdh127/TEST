package Leetcode;
/*给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。
注意，如果字符已经是 'O' ，只需要保持 不变 。
返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
*/
public class Test94 {
    public int minimumMoves(String s) {
        int n=s.length();
        //指向字符串位置的指针
        int index=0;
        //记录操作次数
        int count=0;
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        //没有遍历完字符串时
        while (index<n){
            //当前字符是X时
            if (s.charAt(index)=='X'){
                //统计操作次数
                count++;
                //连续修改3位O
                for (int i = 0; i < 3; i++) {
                    sb.append('O');
                }
                //指针向后移动3位
                index+=3;
            }
            //如果当前字符是'O'，拼接进字符串sb中，指针向后移动一位
            else {
                sb.append('O');
                index++;
            }
        }
        //返回操作次数
        return count;
    }
}
