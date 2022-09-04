package Jianzhioffer02;


import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class Test34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null) {
            return res;
        }
        recur(res, path, root, 0, target);
        return res;

    }

    public void recur(List<List<Integer>> res, LinkedList<Integer> path, TreeNode root, int sum, int target) {
        //当前节点为空时，直接返回
        if (root == null) {
            return;
        }
        //根
        //和累加上当前节点的值
        sum += root.val;
        //路径中添加当前节点的值
        path.addLast(root.val);
        //如果路径和等于目标值，并且当前节点的左节点为空并且当前节点的右节点为空
        //将路径添加到结果集中
        if (sum == target && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        //左
        recur(res, path, root.left, sum, target);
        //右
        recur(res, path, root.right, sum, target);
        //将刚刚放进路径中的元素删除
        path.removeLast();
    }
}
