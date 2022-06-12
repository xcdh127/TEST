package TTT;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test11 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //队列1
        Queue<TreeNode> queue1=new LinkedList<>();
        //队列2
        Queue<TreeNode> queue2=new LinkedList<>();
        //将根节点存放到队列1当中
        queue1.offer(root);
        //存放结果
        List<List<Integer>> res=new ArrayList<>();
        //如果根节点为空，直接返回空结果
        if(root==null){
            return res;
        }
        //存放各层的节点
        List<Integer> list=new ArrayList<>();
        //当队列1不为空时
        while (!queue1.isEmpty()){
            //处理当前节点
            TreeNode temp=queue1.poll();
            //当前节点不为空时
            if (temp!=null){
                //将当前节点添加存放每一层的数组中
                list.add(temp.val);
                //当左子节点不为空时
                if(temp.left!=null){
                    //将左子节点存放到队列2中
                    queue2.offer(temp.left);
                }
                //当右子节点不为空时
                if(temp.right!=null){
                    //将右子节点存放到队列1中
                    queue2.offer(temp.right);
                }
            }
            //当队列1为空时
            if(queue1.isEmpty()){
                //将当前这一层的节点添加到结果中
                res.add(list);
                //将队列2赋值给队列1
                queue1=queue2;
                //新建一个数组，赋值给list
                list=new ArrayList<>();
                //新建一个链表赋值给queue2
                queue2=new LinkedList<TreeNode>();
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
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


