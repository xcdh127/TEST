package Leetcode;

import java.util.Arrays;

/*一个 句子 指的是一个序列的单词用单个空格连接起来，
且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
我们可以给一个句子添加 从 1 开始的单词位置索引 ，
并且将句子中所有单词 打乱顺序 。
比方说，句子 "This is a sentence" 可以被打乱顺序得到
 "sentence4 a3 is2 This1" 或者 "is2 sentence4 This1 a3" 。
给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。
*/
public class Test53 {
    public String sortSentence(String s) {
        //将字符串按照空格拆分放到数组中
        String[] str=s.split(" ");
        int n=str.length;
        //新建自定义类数组
        Sentence[] sentences=new Sentence[n];
        for (int i = 0; i < n; i++) {
            //将字符串截取出来
            String string=str[i].substring(0,str[i].length()-1);
            //将该字符串的新排序位置取出来
            int index=Integer.parseInt(str[i].substring(str[i].length()-1));
            //根据这两个信息创建出新的sentence对象
            sentences[i]=new Sentence(string,index);
        }
        //使用自定义排序规则将数组排序
        Arrays.sort(sentences,(a,b)->(compare(a,b)));
        //存放结果的数组
        String[] res=new String[n];
        //将字符串放进数组中
        for (int i = 0; i < n; i++) {
            res[i]=sentences[i].s;
        }
        //使用sb拼接字符数组中的所有的字符串
        StringBuilder sb=new StringBuilder();
        for (String st:res){
            sb.append(st+" ");
        }
        //删掉最后的空格
        sb.deleteCharAt(sb.length()-1);
        //返回结果
        return sb.toString();
    }
    //自定义排序规则
    public int compare(Sentence sentence1,Sentence sentence2){
        //对字符串的排位信息进行排序
        int index1=sentence1.i;
        int index2=sentence2.i;
        //字符index字段进行排序，升序排序
        return index1-index2;
    }


}
//自定义类
//s是当前字符串
//i是当前字符串排位位置
class Sentence{
    String s;
    int i;
    Sentence(String s,int i){
        this.s=s;
        this.i=i;
    }
}
