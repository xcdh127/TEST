package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*二叉树中，如果一个节点是其父节点的唯一子节点，
则称这样的节点为 “独生节点” 。二叉树的根节点不会是独生节点，因为它没有父节点。
给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。
数组的顺序 不限 。
*/
public class Test22 {
    //存放所有的独自子节点的数组
    List<Integer> list=new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        recur(root);
        //将此数组返回
        return list;
    }
    public void recur(TreeNode root){
        //当根节点为空时，直接返回
        if (root==null){
            return;
        }
        //根
        //当根节点只有左子节点时，将左子节点放进list中
        if (root.left!=null && root.right==null){
            list.add(root.left.val);
        }
        //当根节点只有右子节点时，将右子节点放进list中
        if (root.left==null && root.right!=null){
            list.add(root.right.val);
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
    }

}
