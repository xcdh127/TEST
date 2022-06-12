package Leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static void main(String[] args) {
        deserialize("[0]");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //如果根节点为空，返回空字符串
        if (root==null){
            return "";
        }
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        //两个队列
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        //根节点入队
        queue1.offer(root);
        //队列1不为空时
        while (!queue1.isEmpty()){
            //处理当前节点
            TreeNode temp=queue1.poll();
            //当前节点不为空
            if (temp!=null){
                sb.append(temp.val+",");
                queue2.offer(temp.left);
                queue2.offer(temp.right);
            }
            //当前节点为空
            else {
                sb.append("null,");
            }
            //队列1为空
            if (queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        //删除最后的,
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        //当data为空，直接返回null
        if (data==null || data.length()==0){
            return null;
        }
        //两个队列
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        data=data.substring(1,data.length()-1);
        String[] str=data.split(",");
        int index=1;
        //创建根节点
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()){
            //处理当前节点
            TreeNode temp=queue1.poll();
            //当前节点不为空时
            if (temp!=null){
                //不为空创建节点
                if (!str[index].equals("null")){
                    temp.left=new TreeNode(Integer.parseInt(str[index]));
                    queue2.offer(temp.left);
                }
                //下一位置
                index++;
                //不为空创建节点
                if (!str[index].equals("null")){
                    temp.right=new TreeNode(Integer.parseInt(str[index]));
                    queue2.offer(temp.right);
                }
                //下一位置
                index++;
            }
            //队列1为空，交换队列2赋值给队列1
            if (queue1.isEmpty()){
                queue1=queue2;
                queue2=new LinkedList<>();
            }
        }
        //返回根节点
        return root;
    }
}
