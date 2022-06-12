package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
给定一棵二叉树 root 代表焰火，
节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
*/
public class Test24 {
    Set<Integer> set=new HashSet<>();
    public int numColor(TreeNode root) {
        recur(root);
        //返回set的大小
        return set.size();
    }
    public void recur(TreeNode root){
        //当根节点为空时，直接返回
        if (root==null){
            return;
        }
        //根
        //将当前节点放进set中
        set.add(root.val);
        //左
        recur(root.left);
        //右
        recur(root.right);
    }
}
