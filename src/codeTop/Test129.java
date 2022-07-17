package codeTop;

import java.util.ArrayList;
import java.util.List;

/*给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：
例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。
叶节点 是指没有子节点的节点。
示例 1：
输入：root = [1,2,3]
输出：25
解释：
从根到叶子节点路径 1->2 代表数字 12
从根到叶子节点路径 1->3 代表数字 13
因此，数字总和 = 12 + 13 = 25
示例 2：
输入：root = [4,9,0,5,1]
输出：1026
解释：
从根到叶子节点路径 4->9->5 代表数字 495
从根到叶子节点路径 4->9->1 代表数字 491
从根到叶子节点路径 4->0 代表数字 40
因此，数字总和 = 495 + 491 + 40 = 1026
提示：
树中节点的数目在范围 [1, 1000] 内
0 <= Node.val <= 9
树的深度不超过 10
*/
public class Test129 {
    List<Integer> res=new ArrayList<>();
    int sum;
    public int sumNumbers(TreeNode root) {
        recur(root);
        //记录和
        int count=0;
        //求和
        for (int num :res) {
            count+=num;
        }
        //返回结果
        return count;
    }
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        //根
        //计算此路径上的和
        sum=sum*10+root.val;
        //遇到叶子节点，叶子节点的特点：此节点的左子节点为空，右子节点也为空
        if (root.left==null && root.right==null){
            //将这个路径的值添加到结果集中
            res.add(sum);
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //还原到父节点的状态，先剪掉当前节点的值，再除以10
        sum=(sum-root.val)/10;
    }
}
