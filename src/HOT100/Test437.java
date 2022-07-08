package HOT100;

import java.util.HashMap;
import java.util.Map;

/*给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
示例 1：
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
提示:
二叉树的节点个数的范围是 [0,1000]
-109 <= Node.val <= 109 
-1000 <= targetSum <= 1000 
*/
public class Test437 {
    int count=0;
    Map<Integer,Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        //初始化路径和为0出现1次
        map.put(0,1);
        return recur(root,targetSum,0);
    }
    public int recur(TreeNode root,int targetSum,int sum){
        if (root==null){
            return 0;
        }
        //根，路径和加上当前节点的值
        sum+=root.val;
        //累加 路径和-targetSum的个数
        count=map.getOrDefault(sum-targetSum,0);
        //将此路径和的出现的次数+1
        map.put(sum,map.getOrDefault(sum,0)+1);
        //左
        count+=recur(root.left,targetSum,sum);
        //右
        count+=recur(root.right,targetSum,sum);
        //将和为sum的路径个数-1
        map.put(sum,map.get(sum)-1);
        //返回路径数
        return count;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
class Solution {
    int count=0;
    Map<Integer,Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);

        return recur(root,targetSum,0);

    }
    public int recur(TreeNode root,int targetSum,int sum){
        if (root==null){
            return 0;
        }
        sum+=root.val;
        count=map.getOrDefault(sum-targetSum,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        count+=recur(root.left,targetSum,sum);
        count+=recur(root.right,targetSum,sum);
        map.put(sum,map.get(sum)-1);
        return count;
    }
}*/