package CodeDream;

/*给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：
首先找到需要删除的节点；
如果找到了，删除它。
示例 1:
输入：root = [5,3,6,2,4,null,7], key = 3
输出：[5,4,6,2,null,null,7]
解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
另一个正确答案是 [5,2,6,null,4,null,7]
示例 2:
输入: root = [5,3,6,2,4,null,7], key = 0
输出: [5,3,6,2,4,null,7]
解释: 二叉树不包含值为 0 的节点
示例 3:
输入: root = [], key = 0
输出: []
提示:
节点数的范围 [0, 104].
-105 <= Node.val <= 105
节点值唯一
root 是合法的二叉搜索树
-105 <= key <= 105
*/
public class Test450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //当前节点为空时，直接返回空
        if (root == null) {
            return null;
        }
        //当前节点的值大于key时
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        //当前节点值小于key时
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        //当前节点的值等于待删除key值时
        else if (root.left == null && root.right == null) {
            return null;
        }
        //当前节点的值等于待删除key值时
        else if (root.left != null) {
            root.val = getPrev(root);
            root.left = deleteNode(root.left, root.val);
        }
        //当前节点的值等于待删除key值时
        else {
            root.val = getNext(root);
            root.right = deleteNode(root.right, root.val);
        }
        //返回当前节点
        return root;
    }

    //获取当前节点的前一个节点
    public int getPrev(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    //获取当前节点的后一个节点
    public int getNext(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
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
class Solution6 {
    //获取当前节点的前一个节点
    public int getPrev(TreeNode root) {
        //root指向左子树
        root = root.left;
        //当左子树的右子节点不为空时
        while (root.right != null) {
            //root指向根节点的右子节点
            root = root.right;
        }
        //返回root节点的值
        return root.val;
    }

    //获取当前节点的下一个节点
    public int getNext(TreeNode root) {
        //root指向右子树
        root = root.right;
        //root左子节点不为空时，一直找到最左边的节点
        while (root.left != null) {
            root = root.left;
        }
        //返回root节点的值
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        //当根节点为空时
        if (root == null) {
            //返回null值
            return null;
        }
        //当前节点小于key值时，表明要删除的键值在右子树上
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        //当前节点大于key值时，表明要删除的键值在左子树上
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        //当前节点的左子节点为空，并且右子节点为空，root为null
        else if (root.left == null && root.right == null) {
            root = null;
        }
        //当root节点的左子节点不为空时
        else if (root.left != null) {
            //获取前一个节点的值
            root.val = getPrev(root);
            //删除掉这个节点
            root.left = deleteNode(root.left, root.val);
        }
        //当root节点的右子节点不为空时
        else {
            //获取后一个节点的值
            root.val = getNext(root);
            //删除掉这个节点
            root.right = deleteNode(root.right, root.val);
        }
        //返回root
        return root;
    }
}