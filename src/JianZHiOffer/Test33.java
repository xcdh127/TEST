package JianZHiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
提示：
节点总数 <= 1000
*/
public class Test33 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if (root==null)return res;
        List<Integer> list=new ArrayList<>();
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
                res.add(list);
                list=new ArrayList<>();
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        return res;
    }
}
