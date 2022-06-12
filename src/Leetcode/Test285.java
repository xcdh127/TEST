package Leetcode;
/*给你一个字符串 s 和一个字符 letter ，
返回在 s 中等于 letter 字符所占的 百分比 ，
向下取整到最接近的百分比。*/
public class Test285 {
    public int percentageLetter(String s, char letter) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==letter){
                count++;
            }
        }
        return count*100/s.length();
    }
}
