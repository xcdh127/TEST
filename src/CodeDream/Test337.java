package CodeDream;

import java.util.HashMap;
import java.util.Map;

/*小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
示例 1:
输入: root = [3,2,3,null,3,null,1]
输出: 7
解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
示例 2:
输入: root = [3,4,5,1,3,null,1]
输出: 9
解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
提示：
树的节点数在 [1, 104] 范围内
0 <= Node.val <= 104
*/
public class Test337 {
    //选中当前节点的最高金额，存放节点和此时偷取的金额
    Map<TreeNode, Integer> xuanzhong = new HashMap<>();
    //没有选中当前节点的最高金额，存放节点和此时偷取的金额
    Map<TreeNode, Integer> meixuanzhong = new HashMap<>();

    public int rob(TreeNode root) {
        recur(root);
        return Math.max(xuanzhong.get(root), meixuanzhong.get(root));
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //根
        //选中根节点(不可以选择树的左节点和右节点，此时和为根节点的值+没选择左子节点的值+没选中右子节点的值)
        xuanzhong.put(root, root.val + meixuanzhong.getOrDefault(root.left, 0) + meixuanzhong.getOrDefault(root.right, 0));
        //不选中根节点，可以选择左子树或者右子树，此时和为选择与不选择左子节树的较大者+选择与不选择右子树的最大者
        meixuanzhong.put(root, Math.max(xuanzhong.getOrDefault(root.left, 0), meixuanzhong.getOrDefault(root.left, 0)) +
                Math.max(xuanzhong.getOrDefault(root.right, 0), meixuanzhong.getOrDefault(root.right, 0)));
    }
}

class Solution17 {
    //当前节点被选中的最高金额
    Map<TreeNode, Integer> f = new HashMap<>();
    //当前节点没有被选中的最高金额
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        recur(root);
        return Math.max(f.get(root), g.get(root));

    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //根
        //处理根节点，选择根节点
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        //不选择根节点,此时最大值为选择或者不选择左右子节点较大的一个
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) +
                Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
}