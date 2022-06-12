package TTT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test14 {
    List<Integer> list=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        recur(root1);
        recur(root2);
        //将所有节点排序
        Collections.sort(list);
        return list;

    }
    //取到二叉树全部节点
    public void recur(TreeNode root){
        if (root==null){
            return ;
        }
        recur(root.left);
        recur(root.right);
        list.add(root.val);
    }
}
