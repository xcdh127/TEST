package codeTop;

import java.util.*;

/*给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[20,9],[15,7]]
示例 2：
输入：root = [1]
输出：[[1]]
示例 3：
输入：root = []
输出：[]
提示：
树中节点数目在范围 [0, 2000] 内
-100 <= Node.val <= 100
*/
public class Test103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty()){
            TreeNode temp=queue1.poll();
            if (temp!=null){
                list.add(temp.val);
                if (temp.left!=null){
                    queue2.offer(temp.left);
                }
                if (temp.right!=null){
                    queue2.offer(temp.right);
                }
            }
            if (queue1.isEmpty()){
                if (res.size()%2==1){
                    Collections.reverse(list);
                }
                res.add(list);
                list=new ArrayList<>();
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        return res;
    }
}
