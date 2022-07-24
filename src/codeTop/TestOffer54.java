package codeTop;
/*给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
示例 1:
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
  2
输出: 4
示例 2:
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
限制：
1 ≤ k ≤ 二叉搜索树元素个数
*/
public class TestOffer54 {
    //记录结果节点
    TreeNode res;
    //全局常量k
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        //递归
        recur(root);
        //返回结果
        return res.val;
    }
    //二叉搜索树的中序遍历是递增的，逆中序遍历就是从大到小
    public void recur(TreeNode root){
        if (root==null){
            return;
        }
        //右
        recur(root.right);
        //根
        //越过一个节点就将k值-1
        k--;
        //当k==0时
        if (k==0){
            //结果节点指向root节点
            res=root;
        }
        //左
        recur(root.left);
    }
}
