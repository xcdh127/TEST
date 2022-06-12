package Leetcode;
/*给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
这些字符串可以每个一行，排成一个网格。
例如，strs = ["abc", "bce", "cae"] 可以排列为：
abc
bce
cae
你需要找出并删除 不是按字典序升序排列的 列。
在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）
都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
返回你需要删除的列数。
*/
public class Test111 {
    public int minDeletionSize(String[] strs) {
        //统计要删除的列数
        int count=0;
        //首先遍历每一个列
        for (int i = 0; i < strs[0].length(); i++) {
            //遍历上下相邻单词的字母顺序是否字典序
            for (int j = 1; j < strs.length; j++) {
                //如果某一列的某相邻单词字典序不相同时，count++,跳出循环
                if (strs[j].charAt(i)-strs[j-1].charAt(i)<0){
                    count++;
                    break;
                }
            }
        }
        //返回count
        return count;
    }
}
