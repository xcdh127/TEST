package codeTop;

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
public class TestOffer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<Integer> subset=new LinkedList<>();
        recur(res,subset,0,target,root);
        return res;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> path,int sum,int target,TreeNode root){
        if (root==null){
            return;
        }
        //根
        //求路径和
        sum+=root.val;
        //向路径中添加当前节点值
        path.addLast(root.val);
        //当此节点是叶子节点时，并且路径和等于目标值target
        if (root.left==null && root.right==null && sum==target){
            //将此条路径，添加到结果中
            res.add(new LinkedList<>(path));
        }
        //左
        recur(res,path,sum,target,root.left);
        //右
        recur(res,path,sum,target,root.right);
        //将最后添加大节点，从路径中删除
        path.removeLast();
    }
}
