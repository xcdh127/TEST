package JianZHiOffer;

import java.util.*;

/*请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
  [20,9],
  [15,7]
]
提示：
节点总数 <= 1000
*/
public class Test34 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if (root==null)return res;
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
