package codeTop;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：
输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：
输入：root = [1,2], targetSum = 0
输出：[]
提示：
树中节点总数在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/
public class Test113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //结果
        List<List<Integer>> res=new ArrayList<>();
        //子集
        LinkedList<Integer> subset=new LinkedList<>();
        //回溯
        recur(res,subset,root,0,targetSum);
        //返回结果
        return res;
    }
    public void recur(List<List<Integer>> res, LinkedList<Integer> subset,TreeNode root,int sum,int targetSum){
        if (root==null){
            return;
        }
        //根
        sum+=root.val;
        //将子集都根节点添加到子集中
        subset.addLast(root.val);
        //当遍历到根节点的左节点为空，并且根节点的右节点为空，并且和为目标值时，将subset添加到结果res中
        if (root.left==null && root.right==null && sum==targetSum){
            res.add(new LinkedList<>(subset));
        }
        //左
        recur(res,subset,root.left,sum,targetSum);
        //右
        recur(res,subset,root.right,sum,targetSum);
        //子集中删除刚刚添加的数字
        subset.removeLast();
    }
}
