package JianZHiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]
提示：
节点总数 <= 1000
*/
public class Test32 {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(root);
        List<Integer> res=new ArrayList<>();
        while (!queue1.isEmpty()){
            TreeNode temp=queue1.poll();
            if (temp!=null){
                res.add(temp.val);
                if (temp.left!=null){
                    queue2.offer(temp.left);
                }
                if (temp.right!=null){
                    queue2.offer(temp.right);
                }
            }
            if (queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
