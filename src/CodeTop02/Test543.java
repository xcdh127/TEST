package CodeTop02;

/*给定一棵二叉树，你需要计算它的直径长度。
一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
示例 :
给定二叉树
          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
注意：两结点之间的路径长度是以它们之间边的数目表示。
*/
public class Test543 {
    int maxLen = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return maxLen;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        int right = recur(root.right);
        maxLen = Math.max(left + right, maxLen);
        return 1 + Math.max(left, right);
    }
}
