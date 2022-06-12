package JianZHiOffer;
/*请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
限制：
0 <= 节点个数 <= 1000
*/
public class Test28 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode left,TreeNode right){
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null){
            return false;
        }
        return left.val==right.val && recur(left.left,right.right) && recur(left.right,right.left);
    }
}
