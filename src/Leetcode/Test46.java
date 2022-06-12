package Leetcode;
/*给你一个日志数组 logs。每条日志都是以空格分隔的字串，
其第一个字为字母与数字混合的 标识符 。
有两种不同类型的日志：
字母日志：除标识符之外，所有字均由小写字母组成
数字日志：除标识符之外，所有字均由数字组成
请按下述规则将日志重新排序：
所有 字母日志 都排在 数字日志 之前。
字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
数字日志 应该保留原来的相对顺序。
返回日志的最终顺序。
*/

import java.util.Arrays;

/*输入：logs = ["dig1 8 1 5 1","let1 art can",
"dig2 3 6","let2 own kit dig","let3 art zero"]
输出：["let1 art can","let3 art zero","let2 own kit dig",
"dig1 8 1 5 1","dig2 3 6"]
*/
public class Test46 {
    public String[] reorderLogFiles(String[] logs) {
        int n=logs.length;
        Pair[] pair=new Pair[n];
        //将所有的日志和日志在数组中的下表记录在Pair类中
        for (int i = 0; i < n; i++) {
            pair[i]=new Pair(logs[i],i);
        }
        //自定义排序
        Arrays.sort(pair,(a,b)->(logCompare(a,b)));
        //用于存放结果的字符串的数组
        String[] res=new String[logs.length];
        //将排过序的pair数组中的日志信息，放到结果数组中
        for (int i = 0; i < logs.length; i++) {
            res[i]=pair[i].log;
        }
        //返回结果数组
        return res;
    }

    public int logCompare(Pair pair1,Pair pair2){
        //获取对象的log日志

        String log1=pair1.log;
        String log2=pair2.log;
        int index1=pair1.index;
        int index2=pair2.index;
        //这个方法是将字符串按照空格分割成两个部分，前面是日志的类型,后面是日志的内容
        String[] split1=log1.split(" ",2);
        String[] split2=log2.split(" ",2);
        //判断博客是否是数字的日志
        boolean isDigit1=Character.isDigit(split1[1].charAt(0));
        boolean isDigit2=Character.isDigit(split2[1].charAt(0));
        //如果是数字日志就按照它在数组中的位置进行排序
        if (isDigit1 && isDigit2){
            return index1-index2;
        }
        //如果都不是字母日志
        if (!isDigit1 && !isDigit2){
            //比较两个字符串的字典序
            int sc=split1[1].compareTo(split2[1]);
            //如果个字符串不相等，直接返回比较结果
            if (sc!=0){
                return sc;
            }
            //否则就比较两个日志的类型信息
            return split1[0].compareTo(split2[0]);
        }
        //如果一个是数字日志，一个是字母日志
        //因为字日志时排在数字日志的后面的，所以当第一个参数是数字日志后，就直接返回1；
        return isDigit1?1:-1;
    }


}

class Pair{
    String log;
    int index;
    Pair(String log,int index){
        this.log=log;
        this.index=index;
    }
}




/*
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int length = logs.length;
        Pair[] arr = new Pair[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Pair(logs[i], i);
        }
        Arrays.sort(arr, (a, b) -> logCompare(a, b));
        String[] reordered = new String[length];
        for (int i = 0; i < length; i++) {
            reordered[i] = arr[i].log;
        }
        return reordered;
    }

    public int logCompare(Pair pair1, Pair pair2) {
        String log1 = pair1.log, log2 = pair2.log;
        int index1 = pair1.index, index2 = pair2.index;
        String[] split1 = log1.split(" ", 2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        if (isDigit1 && isDigit2) {
            return index1 - index2;
        }
        if (!isDigit1 && !isDigit2) {
            int sc = split1[1].compareTo(split2[1]);
            if (sc != 0) {
                return sc;
            }
            return split1[0].compareTo(split2[0]);
        }
        return isDigit1 ? 1 : -1;
    }
}

class Pair {
    String log;
    int index;

    public Pair(String log, int index) {
        this.log = log;
        this.index = index;
    }
}
*/

