package codetophuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
示例 1：
输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
输出：["/a","/c/d","/c/f"]
解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
示例 2：
输入：folder = ["/a","/a/b/c","/a/b/d"]
输出：["/a"]
解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
示例 3：
输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
输出: ["/a/b/c","/a/b/ca","/a/b/d"]
提示：
1 <= folder.length <= 4 * 104
2 <= folder[i].length <= 100
folder[i] 只包含小写字母和 '/'
folder[i] 总是以字符 '/' 起始
每个文件夹名都是 唯一 的
*/
public class Test1233 {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        //对数组按照字典序排序,具有相同子目录的文件夹会排在一起
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        //将第一个文件夹放进结果集中
        res.add(folder[0]);
        //记第一个文件夹为根文件夹
        String rootFolder = folder[0];
        //记录根目录的长度
        int rootSize = rootFolder.length();
        //从第二个文件夹向后遍历
        for (int i = 1; i < n; i++) {
            //取出当前文件夹
            String curFolder = folder[i];
            //当前文件夹的长度
            int curSize = curFolder.length();
            //当前的文件夹长度小于等于根文件夹长度 或者 当前文件夹的rootSize长度不为/ 或者当前文件夹与根文件长度相等的文件夹名字不相同
            if (curSize <= rootSize || curFolder.charAt(rootSize) != '/' || !curFolder.substring(0, rootSize).equals(rootFolder)) {
                //将当前文件夹添加到结果集中
                res.add(curFolder);
                //接下来的对比就是根据这个文件夹为基准开始向后比较
                //根文件夹等于当前文件夹
                rootFolder = curFolder;
                //根文件夹的大小等于当前文件夹的大小
                rootSize = curSize;
            }
        }
        //返回结果
        return res;
    }
}


class Solution113 {
    public List<String> removeSubfolders(String[] folder) {

        int n = folder.length;

        Arrays.sort(folder);

        List<String> res = new LinkedList<>();
        res.add(folder[0]);
        String rootFolder = folder[0];
        int rootSize = rootFolder.length();
        for (int i = 1; i < n; i++) {
            String curFolder = folder[i];
            int curSize = curFolder.length();
            if (curSize <= rootSize || curFolder.charAt(rootSize) != '/' || !curFolder.substring(0, rootSize).equals(rootFolder)) {
                res.add(curFolder);
                rootFolder = curFolder;
                rootSize = curSize;
            }
        }

        return res;
    }
}

