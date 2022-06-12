package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*Excel 表中的一个单元格 (r, c) 会以字符串 "<col><row>" 的形式进行表示，其中：
<col> 即单元格的列号 c 。用英文字母表中的 字母 标识。
例如，第 1 列用 'A' 表示，第 2 列用 'B' 表示，第 3 列用 'C' 表示，以此类推。
<row> 即单元格的行号 r 。第 r 行就用 整数 r 标识。
给你一个格式为 "<col1><row1>:<col2><row2>" 的字符串 s ，其中 <col1> 表示 c1 列，
<row1> 表示 r1 行，<col2> 表示 c2 列，<row2> 表示 r2 行，并满足 r1 <= r2 且 c1 <= c2 。
找出所有满足 r1 <= x <= r2 且 c1 <= y <= c2 的单元格，并以列表形式返回。
单元格应该按前面描述的格式用 字符串 表示，并以 非递减 顺序排列（先按列排，再按行排）。
*/
public class Test80 {
    public List<String> cellsInRange(String s) {
        String[] str=s.split(":");
        //获取第一个单元格的数字
        //字符1
        char ch1=str[0].charAt(0);
        //字符2
        char ch2=str[1].charAt(0);
        //第一个字符后的标号
        int numA=str[0].charAt(1)-'0';
        //第二个字符后的标号
        int numB=str[1].charAt(1)-'0';
        //获取两个标号的最大和最小值
        int numMax=Math.max(numA,numB);
        int numMin=Math.min(numA,numB);
        //返回结果
        List<String> list=new ArrayList<>();
        //特殊处理第一列列信息和最后一列信息
        for (char ch=ch1;ch<=ch2;ch++){
            //第一列从numA开始向下扫描到标号最大值
            if (ch==ch1){
                for (int i = numA; i <=numMax ; i++) {
                    list.add(String.valueOf(ch)+i);
                }
            }
            //最后一列从numB开始向后扫描标号的最小值
            else if (ch==ch2){
                for (int i = numMin; i <=numB ; i++) {
                    list.add(String.valueOf(ch)+i);
                }
            }
            //处理中间位置上的列，从最小的标号开始向后遍历到最大的标号
            else {
                for (int i = numMin; i <=numMax ; i++) {
                    list.add(String.valueOf(ch)+i);
                }
            }
        }
        //返回结果
        return list;
    }
}
