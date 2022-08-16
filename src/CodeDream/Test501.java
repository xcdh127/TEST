package CodeDream;

import java.util.*;

/*给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。
假定 BST 满足如下定义：
结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树
示例 1
输入：root = [1,null,2,2]
输出：[2]
示例 2：
输入：root = [0]
输出：[0]
提示：
树中节点的数目在范围 [1, 104] 内
-105 <= Node.val <= 105
*/
public class Test501 {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        list.add(cur.val);
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.right;
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            } else if (entry.getValue() > max) {
                list = new ArrayList<>();
                list.add(entry.getKey());
                max = entry.getValue();
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
