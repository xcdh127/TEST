package CodeDream;

/*给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
示例 1:
输入：root = [4,2,7,1,3], val = 2
输出：[2,1,3]
示例 2:
输入：root = [4,2,7,1,3], val = 5
输出：[]
提示：
数中节点数在 [1, 5000] 范围内
1 <= Node.val <= 107
root 是二叉搜索树
1 <= val <= 107
*/
public class Test700 {

    public TreeNode searchBST(TreeNode root, int val) {
        return recur(root, val);
    }

    public TreeNode recur(TreeNode root, int val) {
        //当root为空或者root节点就是要找的节点时，返回root
        if (root == null || root.val == val) {
            return root;
        }
        //当前节点值大于val时，搜索左子树
        if (root.val > val) {
            return recur(root.left, val);
        }
        //当前节点值小于val时，搜索右子树
        return recur(root.right, val);
    }
}
