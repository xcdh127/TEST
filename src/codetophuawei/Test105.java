package codetophuawei;


import java.util.HashMap;
import java.util.Map;

/*给定两个整数数组 preorder 和 inorder 
，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
示例 1
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]
提示:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Test105 {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //将中序遍历的节点和对应位置放进map中保存
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return recur(preorder, 0, n - 1, 0);
    }

    public TreeNode recur(int[] preorder, int l, int r, int root) {
        //左边界大于右边界，跳出
        if (l > r) {
            return null;
        }
        //拿到根节点在中序遍历中的位置
        int i = map.get(preorder[root]);
        //为根节点创建节点
        TreeNode node = new TreeNode(preorder[root]);
        //构建左子树
        node.left = recur(preorder, l, i - 1, root + 1);
        //构造右子树
        node.right = recur(preorder, i + 1, r, root + i - l + 1);
        //返回构造的节点
        return node;
    }
}
