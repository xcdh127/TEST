package JianZHiOffer;
/*输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。
例如:
给定的树 A:
     3
    / \
   4   5
  / \
 1   2
给定的树 B：
   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
示例 1：
输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
限制：
0 <= 节点个数 <= 10000
*/
public class Test26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null)return false;
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean recur(TreeNode left,TreeNode right){
        //B树已经遍历完毕，说明B树是A树的子结构
        if (right==null){
            return true;
        }
        //A树已经遍历完毕，说明B树不是A树的子结构
        if (left==null){
            return false;
        }
        //比较左右子树对应位置节点值是否相同，检测左子节点，检查右子节点
        return left.val==right.val && recur(left.left,right.left) && recur(left.right,right.right);
    }
}
