package Leetcode;
/*给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
如果第二小的值不存在的话，输出 -1 。
*/
public class Test15 {
    //由题意知道根节点是所有的节点中最小的值
    int ans;
    int rootValue;
    public int findSecondMinimumValue(TreeNode root) {
        //当没有找到第二小的节点时，就返回-1
        ans=-1;
        //根节点的值
        rootValue=root.val;
        recur(root);
        return ans;
    }
    public void recur(TreeNode root){
        //如果遍历到叶子节点直返回
        if (root==null){
            return;
        }
        //如果ans不为-1(已经找到了大于根节点的比当前节点更小的值)，并且当前值大于ans
        if(ans!=-1 && root.val>=ans){
            return;
        }
        //当前节点的值大于根节点的值(并且是比ans还要小的值)
        //那就要更新ans的值
        if(root.val>rootValue){
            ans=root.val;
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
    }
}

/*class Solution {
    int ans;
    int rootvalue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootvalue) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
*/
