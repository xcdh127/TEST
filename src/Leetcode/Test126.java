package Leetcode;
/*每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
下面给出对变更操作的说明：
"../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
"./" ：继续停留在当前文件夹。
"x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
文件系统启动时位于主文件夹，然后执行 logs 中的操作。
执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
*/
/*["./","../","./"]*/
public class Test126 {
    public int minOperations(String[] logs) {
        int n=logs.length;
        //当前处于目录的层数
        int index=0;
        for (int i = 0; i < n; i++) {
            //取到当前目录日志
            String str=logs[i];
            //如果日志信息等于返回父级目录
            if (str.equals("../")) {
                //如果此时不在父级目录，则返回上一级
                if (index>0){
                    index--;
                }
            }
            //如果保持当前目录，跳过
            else if (str.equals("./")){
                continue;
            }
            //进入下一级目录，指针+1
            else {
                index++;
            }
        }
        //返回指针位置
        return index;
    }
}

