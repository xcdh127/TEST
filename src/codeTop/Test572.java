package codeTop;

/*给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
示例 1：
输入：root = [3,4,5,1,2], subRoot = [4,1,2]
输出：true
示例 2：
输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
输出：false
提示：
root 树上的节点数量范围是 [1, 2000]
subRoot 树上的节点数量范围是 [1, 1000]
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
*/
public class Test572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //当根节点root，或者subRoot即诶单为空时，返回false
        if (root == null || subRoot == null) {
            return false;
        }
        //root本身包含subRoot,或者root的左子树包含subRoot，或者root的右子树包含subRoot
        return recur(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        //左子节点为空时，并且右子节点为空时，遍历完两个树后，每个节点都相同，返回true
        if (left == null && right == null) {
            return true;
        }
        //左子节点为空，或者右子节点为空时，某个树先遍历结束了，返回false
        if (left == null || right == null) {
            return false;
        }
        //左子节点值等于右子节点值 并且 左右两个树对应的左右子节点都相同
        return left.val == right.val && recur(left.left, right.left) && recur(left.right, right.right);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution23 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        //root与subRoot是否有相同的结构  左子树是否有subRoot的相同结构 右子树是否有subRoot的相同结构
        return recur(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //判断两棵树的每一个节点是否相同
    public boolean recur(TreeNode left, TreeNode right) {
        //同时遍历到叶子节点，说明两棵树结构相同
        if (left == null && right == null) {
            return true;
        }
        //某一课到达叶子节点，说明结构不同
        if (left == null || right == null) {
            return false;
        }
        //左子树与右子树当前节点值相同，两棵树的当前节点的左子树与右子树对应位置都相同
        return left.val == right.val && recur(left.left, right.left) && recur(left.right, right.right);
    }
}




