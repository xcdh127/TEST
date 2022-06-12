package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给出一棵二叉树，其上每个结点的值都是 0 或 1 。
每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
返回这些数字之和。题目数据保证答案是一个 32 位 整数。
*/
public class Test21 {
    //记录所有的二进制数字的总和
    int sum=0;
    //存放所有的从根节点到叶子节点的路径的字符串
    List<String> list=new ArrayList<>();
    //用于拼接从根节点到叶子节点之间的路径
    StringBuilder sb=new StringBuilder();
    public int sumRootToLeaf(TreeNode root) {
        recur(root);
        //遍历所有的字符串路径
        for (String s :list) {
            //得到字符串的长度
            int len=s.length();
            //记录当前路径构成的数字
            int num=0;
            //指向字符串的指针
            int index=0;
            //从最高位开始计算当前路径构成数字是多少
            for (int i=len-1;i>=0;i--){
                //用当前位置是0还是1乘上这一位的权重，累加得到最后的数字
                num+=Math.pow(2,i)*(s.charAt(index++)-'0');
            }
            //将所有的路径组成的数字累加起来，得到最终的路径总和
            sum+=num;
        }
        //返回路径总和
        return sum;
    }

    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        //根
        //将当前的根节点放进sb中
        sb.append(root.val);
        //当遍历到叶子节点时，将从根节点到叶子节点字符串添加到list中
        if(root.left==null && root.right==null){
            list.add(sb.toString());
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //删除最后添加进来的二进制数
        sb.deleteCharAt(sb.length()-1);
    }

}
