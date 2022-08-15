package CodeDream;

import java.util.HashMap;
import java.util.Map;

/*给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
示例 1:
输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
示例 2:
输入：inorder = [-1], postorder = [-1]
输出：[-1]
提示:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder 和 postorder 都由 不同 的值组成
postorder 中每一个值都在 inorder 中
inorder 保证是树的中序遍历
postorder 保证是树的后序遍历
*/
public class Test106 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(postorder, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode recur(int[] postorder, int root, int l, int r) {
        if (l > r) {
            return null;
        }
        //新建节点
        TreeNode node = new TreeNode(postorder[root]);
        //找到中序遍历中的根节点
        int i = map.get(postorder[root]);
        //左 右root-1 根root
        //左 根i 右r
        //左
        node.left = recur(postorder, root - 1 - (r - i), l, i - 1);
        //右
        node.right = recur(postorder, root - 1, i + 1, r);
        return node;
    }
}
