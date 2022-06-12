package Test00;

public class Solution00 {
    public int[] numberOfLines(int[] widths, String s) {
        int m=widths.length;
        int n=s.length();
        //初始容纳单词的长度
        int line=100;
        //统计需要的行数
        int count_Line=1;
        //遍历字符串判断需要的行数，以及当前行是不是已经存满
        for(int i=0;i<n;i++){
            //当钱单词需要占用的空间大小
            int need=widths[s.charAt(i)-'a'];
            //当前行能够放下当前的字符
            if(line>=need){
                line-=need;
            }
            //当前行放不下当前字符，就换一行，行数+1，空间恢复100
            else{
                line=100;
                line-=need;
                count_Line++;
            }
        }
        return new int[]{count_Line,100-line};
    }

}
