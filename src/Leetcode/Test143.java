package Leetcode;
/*字母的 字母值 取决于字母在字母表中的位置，从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。
对某个由小写字母组成的字符串 s 而言，其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。
例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。
给你三个字符串 firstWord、secondWord 和 targetWord ，每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。
如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。
*/
public class Test143 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        //拼接字符串
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        StringBuilder sb3=new StringBuilder();
        //遍历每一个字符串，转换成数字，拼接进字符串
        for (int i = 0; i < firstWord.length(); i++) {
            sb1.append(firstWord.charAt(i)-'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            sb2.append(secondWord.charAt(i)-'a');
        }
        for (int i = 0; i < targetWord.length(); i++) {
            sb3.append(targetWord.charAt(i)-'a');
        }
        //将两个字符串形成的数字字符串转换从数字
        int numA=Integer.parseInt(sb1.toString());
        int numB=Integer.parseInt(sb2.toString());
        //累加和为target值为true
        return numA+numB==Integer.parseInt(sb3.toString());
    }

}
