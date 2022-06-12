package JianZHiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：
输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：
输入：root = [1,2], targetSum = 0
输出：[]
提示：
树中节点总数在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/
public class Test36 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<Integer> path=new LinkedList<>();
        recur(res,path,target,0,root);
        return res;
    }

    public void recur(List<List<Integer>> res,LinkedList<Integer> path,int target,int sum,TreeNode root){
        if (root==null)return;
        sum+=root.val;
        path.addLast(root.val);
        if (root.left==null && root.right==null && sum==target){
            res.add(new LinkedList<>(path));
        }
        recur(res,path,target,sum,root.left);
        recur(res,path,target,sum,root.right);
        sum-=root.val;
        path.removeLast();
    }
}
