package codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。
示例 2：
输入：root = [1,2,3], targetSum = 5
输出：false
解释：树中存在两条根节点到叶子节点的路径：
(1 --> 2): 和为 3
(1 --> 3): 和为 4
不存在 sum = 5 的根节点到叶子节点的路径。
示例 3：
输入：root = [], targetSum = 0
输出：false
解释：由于树是空的，所以不存在根节点到叶子节点的路径。
提示：
树中节点的数目在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/
public class Test112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<Integer> subset=new LinkedList<>();
        recur(res,subset,root,targetSum,0);
        //如果res结果中的元素大于0时，
        // 表示存在从根节点到叶子节点，和为targetSum的路径，此时返回true
        return res.size()>0;
    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> subset,TreeNode root,int targetSum,int sum){
        if (root==null){
            return;
        }
        //根
        //和+上当前节点的值
        sum+=root.val;
        //将当前节点添加到子集的末尾
        subset.addLast(root.val);
        //此时为叶子节点，左节点为空，右节点为空，并且和等于目标值，此时形成和为targetSum路径
        if (root.left==null && root.right==null && sum==targetSum){
            res.add(new LinkedList<>(subset));
        }
        //左
        recur(res,subset,root.left,targetSum,sum);
        //右
        recur(res,subset,root.right,targetSum,sum);
        //将最后添加的数字删除
        subset.removeLast();
    }
}
