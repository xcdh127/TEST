package HOT100;

import java.util.LinkedList;
import java.util.Queue;

public class Test297 {
}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "";
        }
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(root);
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        while (!queue1.isEmpty()){
            TreeNode temp=queue1.poll();
            if (temp!=null){
                sb.append(temp.val+",");
                queue2.offer(temp.left);
                queue2.offer(temp.right);
            }
            else {
                sb.append("null,");
            }
            if (queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList<TreeNode>();
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.length()==0){
            return null;
        }
        data=data.substring(1,data.length()-1);
        String[] str=data.split(",");
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        queue1.offer(root);
        int i=1;
        while (!queue1.isEmpty()){
            TreeNode temp=queue1.poll();
            if (!"null".equals(str[i])){
                temp.left=new TreeNode(Integer.parseInt(str[i]));
                queue2.offer(temp.left);
            }
            i++;
            if (!"null".equals(str[i])){
                temp.right=new TreeNode(Integer.parseInt(str[i]));
                queue2.offer(temp.right);
            }
            i++;
            if (queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        return root;
    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
