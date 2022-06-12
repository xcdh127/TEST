package Leetcode;

import java.util.*;

/*在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
如果二叉树的两个节点深度相同，但父节点不同 ，则它们是一对堂兄弟节点。
我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
*/
public class Test20 {
//    使用二叉树的层序遍历来搜索树中的堂兄节点
    public boolean isCousins(TreeNode root, int x, int y) {
        //存放一层节点
        Queue<TreeNode> queue1=new LinkedList<>();
        //存放下一层节点
        Queue<TreeNode> queue2=new LinkedList<>();
        //当前层放进根节点
        queue1.offer(root);
        //创建一个存放当前层节点的数组
        List<Integer> list=new ArrayList<>();
        //当队列1不为空时
        while(!queue1.isEmpty()){
            //将队列1中的节点弹出
            TreeNode temp=queue1.poll();
            //当前节点不为空时，处理当前节点
            if (temp!=null){
                list.add(temp.val);
                //左子节点和右子节点都不为空，并且一个值为x,另一个值为y时，直接返回false
                if (temp.left!=null && temp.right!=null){
                    if(temp.left.val==x && temp.right.val==y ||
                       temp.right.val==x && temp.left.val==y){
                        return false;
                    }
                }
                //当左子节点不为空时，将左子节点放进队列2中
                if (temp.left!=null){
                    queue2.offer(temp.left);
                }
                //当右子节点不为空时，将子节点放进队列2中
                if (temp.right!=null){
                    queue2.offer(temp.right);
                }
                //当队列1为空时
                if(queue1.isEmpty()){
                    //新创建一个set集合，来判断这同一层上的元素是不是
                    //存在不属于一个父节点的节点值为x和y的
                    Set<Integer> set=new HashSet<>();
                    //将这一层节点的值存放到集合set当中
                    for (int i = 0; i < list.size(); i++) {
                        set.add(list.get(i));
                    }
                    //判断集合set当中，是不是同时包含有值x和y
                    //如果同时包含节点x和节点y,那么就直接返回true
                    if(set.contains(x) && set.contains(y)){
                        return true;
                    }
                    //将队列1指向队列2
                    queue1=queue2;
                    //为队列2仙新建一个队列
                    queue2=new LinkedList<>();
                    //更新数组
                    list=new ArrayList<>();
                }
            }
        }
        //如果没有找到就返回false
        return false;
    }


}
