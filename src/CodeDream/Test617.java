package CodeDream;

/*给你两棵二叉树： root1 和 root2 。
想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
返回合并后的二叉树。
注意: 合并过程必须从两个树的根节点开始。
示例 1：
输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
输出：[3,4,5,5,4,null,7]
示例 2：
输入：root1 = [1], root2 = [1,2]
输出：[2,2]
提示：
两棵树中的节点数目在范围 [0, 2000] 内
-104 <= Node.val <= 104
*/
public class Test617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recur(root1, root2);
    }

    public TreeNode recur(TreeNode root1, TreeNode root2) {
        //两个根节点都为空时，返回null
        if (root1 == null && root2 == null) {
            return null;
        }
        //当root1不为空，并且root2为空时，返回root1
        else if (root1 != null && root2 == null) {
            return root1;
        }
        //当root1为空，并且root2不为空时，返回root2
        else if (root1 == null && root2 != null) {
            return root2;
        } else {
            //用当前两个节点的值的和创建新的节点
            TreeNode node = new TreeNode(root1.val + root2.val);
            //创建新节点的左子树
            node.left = recur(root1.left, root2.left);
            //创建新节点的右子树
            node.right = recur(root1.right, root2.right);
            //返回node节点
            return node;
        }
    }
}
