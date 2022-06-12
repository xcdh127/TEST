package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
*/
//记录所有的叶子节点序列
public class Test17 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //用于放置第一棵树的所有的叶子节点的值
        List<Integer> list1=new ArrayList<>();
        //用于放置第二棵树的所有的叶子节点的值
        List<Integer> list2=new ArrayList<>();
        //存放root1叶子节点的值
        recur(list1,root1);
        //存放root2叶子节点的值
        recur(list2,root2);
        //当两个数组中的叶子节点值个数不相等时，直接返回false
        if (list1.size()!=list2.size()){
            return false;
        }
        //当两个数组的长度相等时，一次比较两个数组中的值，如果有一个不相等就返回false
        for(int i=0;i<Math.min(list1.size(),list2.size());i++){
            if(list1.get(i)!=list2.get(i)){
                return false;
            }
        }
        //全部相等，相似的
        return true;
    }
    public void recur(List<Integer> list,TreeNode root){
        //根节点为空，直接返回false
        if (root==null){
            return ;
        }
        //左
        recur(list,root.left);
        //右
        recur(list,root.right);
        //根
        //当前节点的左子节点和右子节点都为空时，这个节点就是叶子节点，将叶子节点放进数组中
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
    }

}
