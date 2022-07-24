package codeTop;

import java.util.LinkedList;
import java.util.Queue;

public class Test297 {
}

/*序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
示例 1：
输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
示例 4：
输入：root = [1,2]
输出：[1,2]
提示：
树中结点数在范围 [0, 104] 内
-1000 <= Node.val <= 1000
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        //拼接字符串'['，到字符串中
        sb.append("[");
        //新建队列1
        Queue<TreeNode> queue1 = new LinkedList<>();
        //新建队列2
        Queue<TreeNode> queue2 = new LinkedList<>();
        //队列1添加到根节点中
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
                //将字符串添加到当前节点的值
                sb.append(temp.val + ",");
                //queue2添加到temp.left
                queue2.offer(temp.left);
                //queue2添加到temp.right
                queue2.offer(temp.right);
            }
            //节点为空时，添加null到字符串
            else {
                sb.append("null,");
            }
            //队列1为空时
            if (queue1.isEmpty()) {
                //队列2赋值给队列1
                queue1 = queue2;
                //更新队列2
                queue2 = new LinkedList<>();
            }
        }
        //删除字符串的最后一位节点
        sb.deleteCharAt(sb.length() - 1);
        //添加']'
        sb.append("]");
        //返回结果
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0 || data == null) {
            return null;
        }
        //将data截取掉首尾大括号[]
        data=data.substring(1, data.length() - 1);
        //将字符串按照','分割成字符串
        String[] str = data.split(",");
        //队列1
        Queue<TreeNode> queue1 = new LinkedList<>();
        //队列2
        Queue<TreeNode> queue2 = new LinkedList<>();
        //新建根节点
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        //i位置初始化为1
        int i = 1;
        //将根节点root，加入队列1中
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //弹出当前节点temp
            TreeNode temp = queue1.poll();
            //当前节点不为null时
            if (!"null".equals(str[i])) {
                //新建temp的左子节点
                temp.left = new TreeNode(Integer.valueOf(str[i]));
                //将temp的左子节点，放进队列2中
                queue2.offer(temp.left);
            }
            //进入下一个位置
            i++;
            //当前节点不为null时
            if (!"null".equals(str[i])) {
                //新建temp的右子节点
                temp.right = new TreeNode(Integer.valueOf(str[i]));
                //将temp的右子节点，放进队列2中
                queue2.offer(temp.right);
            }
            //进入下一个位置
            i++;
            //当队列1为空时
            if (queue1.isEmpty()) {
                //将队列2赋值给队列1
                queue1 = queue2;
                //更新队列2
                queue2 = new LinkedList<>();
            }
        }
        //返回根节点
        return root;
    }
}