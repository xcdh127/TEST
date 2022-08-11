package CodeDream;

public class Test222 {
    int count = 0;

    public int countNodes(TreeNode root) {
        recur(root);
        return count;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //根，累加节点个数
        count++;
    }

}
