package codeTop;

import java.util.HashMap;
import java.util.Map;

/*给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        //将中序遍历数组放进map中，值->下标
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(map, postorder, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode recur(Map<Integer, Integer> map, int[] postorder, int root, int l, int r) {
        if (l > r) {
            return null;
        }
        //取出后序遍历中这个数字在中序遍历中的位置
        int i = map.get(postorder[root]);
        //以当前节点，创建根节点
        TreeNode node = new TreeNode(postorder[root]);
        //后序遍历的顺序为：
        //左(root-(r-i)-1) 右(root-1) 根(root)
        //r-i是右子树节点个数，(l,i-1)为左子树，(i+1,r)为右子树
        node.left = recur(map, postorder, root - (r - i) - 1, l, i - 1);
        node.right = recur(map, postorder, root - 1, i + 1, r);
        //返回根节点
        return node;
    }
}

class Solution36 {
    Map<Integer, Integer> map;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer, Integer>();
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(postorder, inorder.length - 1, 0, inorder.length - 1);


    }

    public TreeNode recur(int[] postorder, int root, int l, int r) {
        if (l > r) {
            return null;
        }
        int i = map.get(postorder[root]);
        TreeNode node = new TreeNode(postorder[root]);
        node.left = recur(postorder, root - (r - i) - 1, l, i - 1);
        node.right = recur(postorder, root - 1, i + 1, r);
        return node;
    }


}