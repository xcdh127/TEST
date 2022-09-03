package CodeDream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Testniu {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode temp = queue1.poll();
            if (temp != null) {
                list.add(temp.val);
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            if (queue1.isEmpty()) {
                if (res.size() % 2 == 1) {
                    Collections.reverse(list);
                }
                res.add(list);
                list = new ArrayList<>();
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
