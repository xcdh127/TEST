package Leetcode;

import java.util.*;

/*给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
请使用下述操作来构建目标数组 target ：
Push：从 list 中读取一个新元素， 并将其推入数组中。
Pop：删除数组中的最后一个元素。
如果目标数组构建完成，就停止读取更多元素。
题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
请返回构建目标数组所用的操作序列。
题目数据保证答案是唯一的。
*/

/*输入：target = [1,3], n = 3
输出：["Push","Push","Pop","Push"]
解释：
读取 1 并自动推入数组 -> [1]
读取 2 并自动推入数组，然后删除它 -> [1]
读取 3 并自动推入数组 -> [1,3]
*/
public class Test156 {
    public List<String> buildArray(int[] target, int n) {
        //拿到当前数组的长度
        int length=target.length;
        //用来判断栈中是否有当前元素
        Set<Integer> set=new HashSet<>();
        //用于存放结果的数组
        List<String> res=new ArrayList<>();
        //将所有的target数组中出现的数字添加到set中
        for (int i = 0; i <target.length; i++) {
            set.add(target[i]);
        }
        //遍历数字从1——n查找当前数字是否在数组中
        for (int i = 1; i <=n; i++) {
            //如果当前数组长度已经遍历完毕
            //直接返回结果
            if (length==0){
                return res;
            }
            //当前数字存在于栈中时，向结果中添加push
            //并将数组的长度-1
            if (set.contains(i)){
                res.add("Push");
                length--;
            }
            //否则向结果中添加push,pop表明当前数字不存在于栈中
            else {
                res.add("Push");
                res.add("Pop");
            }
        }
        //返回结果
        return res;
    }
}
