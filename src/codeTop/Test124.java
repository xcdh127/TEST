package codeTop;
/*路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
示例 1：
输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：
输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
提示：
树中节点数目范围是 [1, 3 * 104]
-1000 <= Node.val <= 1000
*/
public class Test124 {
    //记录最大路径和
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recur(root);
        //返回最大值
        return maxSum;
    }
    public int recur(TreeNode root){
        //当遍历到叶子节点时，返回0
        if (root==null){
            return 0;
        }
        //left等于左子树的和与0的较大值
        int left=Math.max(0,recur(root.left));
        //right等于右子树的和与0的较大值
        int right=Math.max(0,recur(root.right));
        //记录根节点+左右子树的和与maxSum的较大值
        maxSum=Math.max(maxSum,root.val+left+right);
        //返回根节点+左子树的和与右子树的和的较大者
        return root.val+Math.max(left,right);
    }
}
