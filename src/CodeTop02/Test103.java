package CodeTop02;

import java.util.ArrayList;
import java.util.List;

/*给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，
层与层之间交替进行）。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[20,9],[15,7]]
示例 2：
输入：root = [1]
输出：[[1]]
示例 3：
输入：root = []
输出：[]
提示：
树中节点数目在范围 [0, 2000] 内
-100 <= Node.val <= 100
*/
public class Test103 {
/*    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();


    }*/

    public static void main(String[] args) {
        Thread t=new Thread() {
            public void run() {
                pong();
            }
        };
            t.run();
        System.out.println("ping");
        }


    static void pong(){
        System.out.println("pong");
    }


}
