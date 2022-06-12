package TTT;

import java.util.HashMap;
import java.util.Map;

/*给定一个二叉树的根节点 root ，和一个整数 targetSum ，
求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，
但是路径方向必须是向下的（只能从父节点到子节点）。
*/
public class Test18 {
    int count=0;
    Map<Integer,Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        //前缀和，和为0出现1次
        map.put(0,1);
        return recur(root,targetSum,0);
    }
    public int recur(TreeNode root,int targetSum,int sum){
        if (root==null){
            return 0;
        }
        //求路径和
        sum+=root.val;
        //统计和为sum-targetSum的路径数
        count=map.getOrDefault(sum-targetSum,0);
        //将此时的路径和记录到map中
        map.put(sum,map.getOrDefault(sum,0)+1);
        //左
        count+=recur(root.left,targetSum,sum);
        //右
        count+=recur(root.right,targetSum,sum);
        //将路径和sum减去，恢复到父节点时的状态
        map.put(sum,map.get(sum)-1);
        return count;
    }

}
